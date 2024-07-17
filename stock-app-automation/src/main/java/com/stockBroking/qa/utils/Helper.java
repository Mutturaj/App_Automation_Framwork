package com.stockBroking.qa.utils;

import com.stockBroking.qa.constants.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Helper {

    private final HashMap<String, String> data;

    public Helper() {
        this.data = new HashMap<>();
    }

    public JSONObject readJsonFile(String path) throws IOException, JSONException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(path)));
        return new JSONObject(jsonContent);
    }

    public HashMap<String, String> jsonToHashMap() throws IOException, JSONException {
        JSONObject jsonObject = readJsonFile(Constants.testDataJsonFile);
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            data.put(key, jsonObject.getString(key));
        }
        return data;
    }

    public String getTestData(String key) throws IOException, JSONException {
        return jsonToHashMap().get(key);
    }

    public List<String> readSearchKeywordsTab(String searchData, String tab) {
        try {
            JSONArray tabArray = readJsonFile(Constants.searchKeywordsTab).getJSONObject(searchData).getJSONArray(tab);
            return convertJSONArrayToList(tabArray);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static JSONObject getRandomElement(JSONArray jsonArray) throws JSONException {
        Random random = new Random();
        int randomIndex = random.nextInt(jsonArray.length());
        return jsonArray.getJSONObject(randomIndex);
    }

    private static List<String> convertJSONArrayToList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

}
