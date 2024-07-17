package com.stockBroking.qa.appTests.searchTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.dataprovider.SearchDataProvider;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.pages.searchPage.SearchPage;
import com.stockBroking.qa.pages.watchlist.ManageWatchListPage;
import com.stockBroking.qa.pages.watchlist.WatchListPage;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.NavigationHelper;
import com.stockBroking.qa.utils.TestUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SearchTest extends ShareMarketBaseTest {

    private final TestUtils utils;
    private final LoginHelpers loginHelpers;
    private final Helper helper;

    SearchTest() {
        this.utils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.helper = new Helper();
    }


    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException, JSONException {
        LoginPage loginPage = new LoginPage();
        Thread.sleep(5000);
        if (!loginPage.continueWithMobileNumberPopUp1.getElements().isEmpty()) {
            loginPage.dismissMobileNumberPopUp();
        }
        Thread.sleep(2000);
        if ((!loginPage.useYourPhonePeAccText1.getElements().isEmpty())) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        }
        if (!loginPage.pinField1.getElements().isEmpty()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
        }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Search Scenarios")
    @Story("Validate the Search Scenarios")
    @Test(description = "Ensure that users can filter their search by selecting tabs (All, Stocks, ETF, Index) in the Global & Local Search.", dataProvider = "selectSearchTabData", dataProviderClass = SearchDataProvider.class)
    void verifyTabsSearchBar(String searchData, String allTab, String stocksTab, String indexTab) throws JSONException, IOException, InterruptedException {
        NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.goToMarketPage();
        SearchPage searchPage = navigationHelper.goToSearchPage();
        utils.waitForElementToDisplay(searchPage.searchField);
        List<String> allTabList = helper.readSearchKeywordsTab(searchData, allTab);
        searchPage.enterSearchData(searchData);
        utils.waitForElementToDisplay(searchPage.allTab);
        searchPage.verifyTabListItems(searchData, allTabList);
        searchPage.clickStocksTab();
        utils.waitForElementToDisplay(searchPage.stocksTab);
        List<String> stocksTabList = helper.readSearchKeywordsTab(searchData, stocksTab);
        searchPage.verifyTabListItems(searchData, stocksTabList);
        searchPage.clickEtfTab();
        utils.waitForElementToDisplay(searchPage.etfTab);
        searchPage.verifyEtfTab(searchData);
        searchPage.clickIndexTab();
        utils.waitForElementToDisplay(searchPage.indexTab);
        List<String> indexTabList = helper.readSearchKeywordsTab(searchData, indexTab);
        searchPage.verifyTabListItems(searchData, indexTabList);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Search Scenarios")
    @Story("Validate the Search Scenarios")
    @Test(description = "Verify that when a user bookmarks a searched stock, the Watchlist page is displayed, and the user can select a watchlist to save the stock", dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    void verifyBookmarkFunctionality(String searchData, String watchListName) {
        WatchListPage watchListPage = new WatchListPage();
        SearchPage searchPage = new SearchPage();
        NavigationHelper navigationHelper = new NavigationHelper();
        watchListPage.removeWatchListStock(searchData, watchListName);
        navigationHelper.goToSearchPage();
        searchPage.bookMarkStock(searchData);
        if (!searchPage.addToWatchListCheckbox.isDisplayed()) {
            ManageWatchListPage manageWatchListPage = new ManageWatchListPage();
            manageWatchListPage.createNewWatchlist(watchListName);
        }
        searchPage.clickAddToWatchListCheckbox();
        searchPage.clickSaveWatchListButton();
        utils.waitForElementToDisplay(searchPage.allChangesSavedText);
        Assert.assertTrue(searchPage.allChangesSavedText.isDisplayed());
        utils.deviceBackKey();
        navigationHelper.goToWatchList();
        watchListPage.setWatchlistName(watchListName);
        watchListPage.watchListName.setElementSync(true);
        watchListPage.setWatchListStock(searchData);
        Assert.assertTrue(watchListPage.watchListStock.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Search Scenarios")
    @Story("Validate the Search Scenarios")
    @Test(description = "Verify that users can search using alphanumeric characters and special characters and also using the full name of a stock", dataProvider = "searchDifferentStrings", dataProviderClass = SearchDataProvider.class)
    void verifyDifferentSearchData(String searchData) {
        SearchPage searchPage = new NavigationHelper().goToSearchPage();
        searchPage.enterSearchData(searchData);
        utils.waitForElementToDisplay(searchPage.allTab);
        searchPage.verifyDifferentSearchData(searchData);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Search Scenarios")
    @Story("Validate the Search Scenarios")
    @Test(description = "Verify that users can search using alphanumeric characters and special characters and also using the full name of a stock", dataProvider = "searchDifferentSectors", dataProviderClass = SearchDataProvider.class)
    void verifyDifferentSectorSearch(String sector, String indice) {
        SearchPage searchPage = new NavigationHelper().goToSearchPage();
        searchPage.enterSearchData(sector);
        utils.waitForElementToDisplay(searchPage.allTab);
        searchPage.verifyDifferentSearchData(indice + sector);
    }
}
