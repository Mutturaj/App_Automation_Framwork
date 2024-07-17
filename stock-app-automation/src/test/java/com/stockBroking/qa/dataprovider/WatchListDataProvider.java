package com.stockBroking.qa.dataprovider;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WatchListDataProvider {

    @DataProvider(name = "watchlistFieldInputData")
    public Object[][] getSelectTabData() {
        String watchListName = "#@-" + RandomStringUtils.random(28, true, true);
        return new Object[][]{
                {watchListName}
        };
    }

    @DataProvider(name = "watchlistAndStockSearchData")
    public Object[][] getWatchlistAndStockSearchData() {
        String searchData = "Tata Steel Ltd.";
        String watchList = "WatchList " + RandomStringUtils.random(2, false, true);
        return new Object[][]{
                {searchData, watchList}
        };
    }

    @DataProvider(name = "sortingOptionsWatchlist")
    public Object[][] getSortingOptionsWatchlist() {
        String watchList = "My First List";
        return new Object[][]{
                {watchList}
        };
    }


    @DataProvider(name = "keywordsForStocksSuggestion")
    public Object[][] getKeywordForStocksSuggestion() {
        String watchList = "WatchList " + RandomStringUtils.random(2, false, true);
        String stock = "IRFC";
        List<String> keywords = new ArrayList<>();
        keywords.add("A");
        keywords.add("B");
        keywords.add("C");
        keywords.add("D");
        keywords.add("E");
        keywords.add("F");
        return new Object[][]{
                {watchList, keywords, stock}
        };
    }

    @DataProvider(name = "updatedWatchlistData")
    public Object[][] getUpdatedWatchlist() {
        String watchList = "UpdatedWatchList " + RandomStringUtils.random(2, false, true);
        return new Object[][]{
                {watchList}
        };
    }

}
