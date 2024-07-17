package com.stockBroking.qa.testRail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockBroking.qa.constants.Constants;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.stockBroking.qa.testRail.TestRailConfig.*;

/**
 * @author kuldeep.yadav
 * @date 15/02/24
 * @package testRail
 */

public class TestRailApis {

    private final ObjectMapper objectMapper;

    public TestRailApis() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Map<String, Object>> getTestCases(int projectId, int suiteId) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        int offset = 0;
        boolean hasNext;
        Map<String, List<Integer>> aggregatedSuiteCasesMap = new HashMap<>();
        do {
            Object jsonObject = client.sendGet("get_cases/" + projectId + "&suite_id=" + suiteId + "&offset=" + offset + "&template_id=1");
            String jsonString = objectMapper.writeValueAsString(jsonObject);
            JsonNode rootNode = objectMapper.readTree(jsonString);
            filterTestcases(rootNode, aggregatedSuiteCasesMap);
            hasNext = rootNode.path("_links").hasNonNull("next");
            if (hasNext) {
                offset += 250;
            }
        } while (hasNext);
        return constructTestPlanPayload(aggregatedSuiteCasesMap);
    }

    public void filterTestcases(JsonNode rootNode, Map<String, List<Integer>> aggregatedSuiteCasesMap) {
        JsonNode casesNode = rootNode.path("cases");
        Iterator<JsonNode> elements = casesNode.elements();
        while (elements.hasNext()) {
            JsonNode caseNode = elements.next();
            int templateId = caseNode.path("template_id").asInt();
            int customPlatform = caseNode.path("custom_platform").asInt();
            JsonNode customAppsTestSuite = caseNode.path("custom_apps_test_suite");
            String suiteId = caseNode.path("suite_id").asText();
            int caseId = caseNode.path("id").asInt();
            if (templateId == 1 && (customPlatform == 1 || customPlatform == 3)) {
                if (customAppsTestSuite.isArray()) {
                    boolean hasTwo = false;
                    boolean hasOneAndTwo = false;
                    for (JsonNode appTestSuite : customAppsTestSuite) {
                        int value = appTestSuite.asInt();
                        if (value == 2) {
                            hasTwo = true;
                        }
                        if (value == 1) {
                            hasOneAndTwo = true;
                        }
                        if (hasTwo || (hasOneAndTwo && hasTwo)) {
                            aggregatedSuiteCasesMap.computeIfAbsent(suiteId, k -> new ArrayList<>()).add(caseId);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void addTestPlan(String platform, List<Map<String, Object>> entries, String mileStoneId) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        List<Map<String, Object>> suiteAndTestRunList = new ArrayList<>();
        Map<Object, Object> data = new HashMap<>();
        data.put("milestone_id", mileStoneId);
        data.put("name", platform + "_" + VERSION + "_ReleasePlan");
        data.put("entries", entries);
        Object responseObject = client.sendPost("add_plan/" + PROJECT_ID, data);
        JsonNode jsonNode = objectMapper.readTree(responseObject.toString());
        System.out.println(jsonNode);
        if (jsonNode.get("entries").isArray()) {
            for (JsonNode node : jsonNode.get("entries")) {
                String suite_Id = node.get("suite_id").asText();
                if (node.get("runs").isArray()) {
                    for (JsonNode run : node.get("runs")) {
                        Map<String, Object> suiteAndTestRunMapping = new HashMap<>();
                        suiteAndTestRunMapping.put("suiteId", suite_Id);
                        suiteAndTestRunMapping.put("run_id", run.get("id").asText());
                        suiteAndTestRunList.add(suiteAndTestRunMapping);
                    }
                }
            }
        }
        objectMapper.writeValue(new File(Constants.suiteTestRunMapping), suiteAndTestRunList);
    }

    private List<Map<String, Object>> constructTestPlanPayload(Map<String, List<Integer>> aggregatedSuiteCasesMap) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : aggregatedSuiteCasesMap.entrySet()) {
            Map<String, Object> suiteObject = new HashMap<>();
            suiteObject.put("suite_id", entry.getKey());
            suiteObject.put("case_ids", entry.getValue());
            result.add(suiteObject);
        }
        return result;
    }

    private String addMileStone() throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        Map<Object, Object> data = new HashMap<>();
        data.put("name", "Release_" + VERSION);
        return objectMapper.readTree(objectMapper.writeValueAsString(client
                        .sendPost("add_milestone/" + PROJECT_ID, data)))
                .get("id").asText();
    }

    public String getTestCaseDetails(String caseId) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        Object object = client.sendGet("get_case/"+caseId);
        JsonNode jsonNode = objectMapper.readTree(object.toString());
        String suite_id = jsonNode.get("suite_id").asText();
        return String.valueOf(getRunIdFromSuiteId(suite_id));
    }

    private String getRunIdFromSuiteId(String suiteId) throws IOException {
        List<Map<String, String>> suiteAndTestRunList = objectMapper.readValue(new File(Constants.suiteTestRunMapping), List.class);
        return suiteAndTestRunList.stream()
                .filter(entry -> suiteId.equals(entry.get("suiteId")))
                .map(entry -> entry.get("run_id"))
                .findFirst().orElse(null);
    }

    public void createReleasePlan(String platform) throws APIException, IOException {
        List<Map<String, Object>> entries = new ArrayList<>();
        int suiteId = 0;
        for (int id : TestRailConfig.suiteIds) {
            suiteId = id;
            List<Map<String, Object>> testcaseWithSuites = getTestCases(PROJECT_ID, suiteId);
            for (Map<String, Object> map : testcaseWithSuites) {
                map.put("include_all", false);
                entries.add(map);
            }
        }
        String mileStoneId = addMileStone();
        addTestPlan(platform, entries, mileStoneId);
    }

    public Object addTestRun(int projectId, int suiteId, String version, String platform, boolean includeAll, List<Integer> caseIds) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        Map<Object, Object> data = new HashMap<>();
        data.put("suite_id", suiteId);
        data.put("name", platform + " " + version + " " + "Daily Test Run");
        data.put("include_all", includeAll);
        data.put("case_ids", caseIds);
        return client.sendPost("add_run/" + projectId, data);
    }

    public void addResultForTestCase(String testCaseId, Map<Object, Object> data) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        String runId = getTestCaseDetails(testCaseId);
        try {
            client.sendPost("add_result_for_case/" + runId + "/" + testCaseId, data);
        }catch (APIException ignore){}

    }

    public void addResultsForTestCases(List<Map<Object, Object>> data) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        Map<Object, List<Map<Object, Object>>> listMap = new HashMap<>();
        listMap.put("results", data);
        client.sendPost("add_results_for_cases/" + "TEST_RUN_ID", listMap);
    }

    public int getTestRun(int projectId, int suiteId) throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        Object response = client.sendGet("get_runs/" + projectId + "&is_completed=0&suite_id=" + suiteId);
        JsonNode jsonNode = objectMapper.readTree(response.toString());
        JsonNode runsNode = jsonNode.get("runs");
        if (runsNode != null) {
            for (JsonNode run : runsNode) {
                String nameText = run.get("name").asText();
                if (nameText.contains(VERSION) && nameText.contains(PLATFORM)) {
                    return run.get("id").asInt();
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    public void closeTestRun() throws APIException, IOException {
        TestRailClient client = new TestRailClient(RAILS_ENGINE_URL);
        client.setAuthToken(AUTH_TOKEN);
        client.sendPost("close_run/" + "TEST_RUN_ID", "");
    }

    public void createDailyTestRun() throws APIException, IOException {
        JsonNode jsonNode = objectMapper.readTree(new File(Constants.dailyTestRunIds));
        JsonNode ids = jsonNode.get("ids");
        List<Integer> caseIds = objectMapper.convertValue(ids, List.class);
        String object = objectMapper.writeValueAsString(addTestRun(PROJECT_ID, SUITE_ID, VERSION, PLATFORM, false, caseIds));
        JsonNode jsonNode1 = objectMapper.readTree(object);
        jsonNode1.get("id").asText();
}
}