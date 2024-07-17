package com.stockBroking.qa.dataprovider;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchDataProvider {
    Random random;

    @DataProvider(name = "selectSearchTabData")
    public Object[][] getSelectTabData() {
        List<String> searchData = new ArrayList<>();
        searchData.add("it");
        searchData.add("Nifty 50");
        String allTab = "allTab";
        String stocksTab = "stocksTab";
        String indexTab = "indexTab";
        random = new Random();
        int randomNumber = random.nextInt(2);
        return new Object[][]{
                {searchData.get(randomNumber), allTab, stocksTab, indexTab}
        };
    }

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        String searchData = "State Bank of India";
        String watchListName = "My First List";
        return new Object[][]{
                {searchData, watchListName}
        };
    }

    @DataProvider(name = "searchDifferentStrings")
    public Object[][] getSearchDifferentStrings() {
        List<String> searchData = new ArrayList<>();
        searchData.add(RandomStringUtils.random(6, true, true));
        searchData.add("Adani Enterprises Ltd.");
        random = new Random();
        int randomNumber = random.nextInt(2);
        return new Object[][]{
                {searchData.get(randomNumber)}
        };
    }

    @DataProvider(name = "searchDifferentSectors")
    public Object[][] getSearchDifferentSectors() {
        String indice = "Nifty ";
        List<String> searchData = new ArrayList<>();
        searchData.add("Bank");
        searchData.add("Auto");
        searchData.add("IT");
        searchData.add("Pharma");
        searchData.add("FMCG");
        searchData.add("Media");
        searchData.add("Metal");
        searchData.add("Healthcare");
        searchData.add("Consumer");
        searchData.add("Financial");
        searchData.add("Oil");
        random = new Random();
        int randomNumber = random.nextInt(searchData.size());
        return new Object[][]{
                {searchData.get(randomNumber), indice}
        };
    }
}
