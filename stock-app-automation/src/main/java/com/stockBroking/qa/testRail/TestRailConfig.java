package com.stockBroking.qa.testRail;

import logger.LogController;
import org.testng.ITestResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRailConfig {

    private final LogController logger;
    private final TestRailApis testRailApis;
    public static List<Map<Object, Object>> listOfMap =  new ArrayList<>();

    public TestRailConfig() {
        this.logger = new LogController(TestRailConfig.class);
        this.testRailApis = new TestRailApis();
    }

    public static final String AUTH_TOKEN="YXV0b21hdGlvbkBwaG9uZXBlLmNvbTpQaG9uZXBlQDEyMw==";
    public static final String RAILS_ENGINE_URL = "https://testrail.ittproxy.phonepe.mh1/api/v2";
    public static final int PROJECT_ID = 23;
    public static final int SUITE_ID = 382;
    public static String VERSION = System.getProperty("version");
    public static String PLATFORM;
    public static final int RETEST=4;
    public static final int Failed_By_Automation = 6;
    public static final int Passed_By_Automation = 7;
    public static final int [] suiteIds = {1341, 1340, 1339, 1337,1338, 1336};


    private Map<Object, Object> getTestRailMetaData(ITestResult result) {
        Map<Object, Object> dataTestRail = new HashMap<>();
        if (result.getStatus() == ITestResult.SUCCESS) {
            dataTestRail.put("status_id", Passed_By_Automation);
            dataTestRail.put("comment", "SUCCESS");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            dataTestRail.put("status_id", Failed_By_Automation);
            dataTestRail.put("comment", "FAILURE" + "\n" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            dataTestRail.put("status_id", RETEST);
            dataTestRail.put("comment", "SKIPPED" + "\n" + result.getThrowable());
        }
        return dataTestRail;
    }

    private Map<Object, Object> getTestRailMetaData(ITestResult result, String parameters) {
        Map<Object, Object> dataTestRail = new HashMap<>();
        if (result.getStatus() == ITestResult.SUCCESS) {
            dataTestRail.put("status_id", Passed_By_Automation);
            dataTestRail.put("comment", "SUCCESS with parameters :" + parameters);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            dataTestRail.put("status_id", Failed_By_Automation);
            dataTestRail.put("comment", "FAILURE with parameters :" + parameters + "\n" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            dataTestRail.put("status_id", RETEST);
            dataTestRail.put("comment", "SKIPPED with parameters :" + parameters + "\n" + result.getThrowable());
        }
        return dataTestRail;
    }

    private Map<Object, Object> getTestRailMetaData(String testCaseId, ITestResult result, String parameters) {
        Map<Object, Object> dataTestRail = new HashMap<>();
        if (result.getStatus() == ITestResult.SUCCESS) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", Passed_By_Automation);
            dataTestRail.put("comment", "SUCCESS with parameters :" + parameters);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", Failed_By_Automation);
            dataTestRail.put("comment", "FAILURE with parameters :" + parameters + "\n" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", RETEST);
            dataTestRail.put("comment", "SKIPPED with parameters :" + parameters + "\n" + result.getThrowable());
        }
        return dataTestRail;
    }

    private Map<Object, Object> getTestRailMetaData(String testCaseId, ITestResult result) {
        Map<Object, Object> dataTestRail = new HashMap<>();
        if (result.getStatus() == ITestResult.SUCCESS) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", Passed_By_Automation);
            dataTestRail.put("comment", "SUCCESS");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", Failed_By_Automation);
            dataTestRail.put("comment", "FAILURE" + "\n" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            dataTestRail.put("case_id", testCaseId);
            dataTestRail.put("status_id", RETEST);
            dataTestRail.put("comment", "SKIPPED" + "\n" + result.getThrowable());
        }
        return dataTestRail;
    }

    public void postTestRailResult(String testRailId, ITestResult result, String parameters) throws APIException, IOException {
        System.out.println("TestId ["+ testRailId +"] with parameter " + parameters + " & Status:"+result.getStatus());
        testRailApis.addResultForTestCase(testRailId, getTestRailMetaData(result, parameters));
    }

    public void postTestRailResult(String testRailId, ITestResult result) throws APIException, IOException {
        System.out.println("TestId ["+ testRailId +"] with & Status:"+result.getStatus());
        testRailApis.addResultForTestCase(testRailId, getTestRailMetaData(result));
    }


    public void addTestRailResultMap(String testRailId, ITestResult result, String parameters) {
        logger.info("TestId ["+ testRailId +"] with parameter " + parameters + " & Status:"+result.getStatus());
        listOfMap.add(getTestRailMetaData(testRailId, result, parameters));
    }

    public void addTestRailResultMap(String testRailId, ITestResult result){
        logger.info("TestId ["+ testRailId +"] with Status:"+result.getStatus());
        listOfMap.add(getTestRailMetaData(testRailId, result));
}

        }