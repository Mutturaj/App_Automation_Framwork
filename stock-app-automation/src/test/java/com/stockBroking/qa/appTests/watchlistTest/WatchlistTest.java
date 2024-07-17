package com.stockBroking.qa.appTests.watchlistTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.dataprovider.WatchListDataProvider;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.pages.searchPage.SearchPage;
import com.stockBroking.qa.pages.watchlist.EditWatchListPage;
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
import com.stockBroking.qa.pages.watchlist.ManageWatchListPage;
import com.stockBroking.qa.pages.watchlist.WatchListPage;
import pagefactory.elements.Element;
import utilities.EnvironmentVariable;

import java.io.IOException;
import java.util.List;

import static listner.ThreadCreator.getLocalDriver;

public class WatchlistTest extends ShareMarketBaseTest {

    private final TestUtils utils;
    private final LoginHelpers loginHelpers;
    private final Helper helper;

    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException, JSONException {
        LoginPage loginPage = new LoginPage();
        if (loginPage.useYourPhonePeAccText.isDisplayed()) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        } else if (loginPage.pinField.isDisplayed()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
    }

    WatchlistTest() {
        this.utils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.helper = new Helper();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Creating the watchlist Scenarios")
    @Test(description = "Verify that the user can create a new Watchlist with a limit of 10, and the default Watchlist name is \"My First List \"", dataProvider = "watchlistFieldInputData", dataProviderClass = WatchListDataProvider.class)
    public void verifyCreateNewWL(String watchListName) {
        NavigationHelper navigationHelper = new NavigationHelper();
        ManageWatchListPage manageWatchListPage = navigationHelper.goToWatchList().clickManageWatchList();
        utils.waitForElementToDisplay(manageWatchListPage.manageWatchlistHeading);
        List<Element> watchListNames = manageWatchListPage.watchListName.getElements();
        List<Element> watchListDeleteIcon = manageWatchListPage.deleteIcons.getElements();
        int watchListSize = watchListDeleteIcon.size();
        while (watchListSize > 7) {
            String watchList = watchListNames.get(--watchListSize).getText();
            manageWatchListPage.deleteWatchList(watchListDeleteIcon.get(watchListSize), watchList);
            watchListDeleteIcon.clear();
            manageWatchListPage.deleteIcons.loadElements();
            watchListSize = manageWatchListPage.deleteIcons.getElements().size();
        }
        manageWatchListPage.clickCreateNewWatchListButton();
        utils.waitForElementToDisplay(manageWatchListPage.createNewWatchListHeader);
        Assert.assertTrue(manageWatchListPage.createNewWatchListHeader.isDisplayed());
        manageWatchListPage.enterWatchListName(watchListName);
        if(EnvironmentVariable.getAvailableInstance().isIos()){
            Assert.assertEquals(manageWatchListPage.enterWatchListNameField.getAttribute("value"), watchListName.substring(0, 30));
        }else {
            Assert.assertEquals(manageWatchListPage.enterWatchListNameField.getAttribute("text"), watchListName.substring(0, 30));
        }
        manageWatchListPage.clickCreateNowButton();
        manageWatchListPage.clickCreateNewWatchListButton();
        utils.waitForElementToDisplay(manageWatchListPage.createNewWatchListHeader);
        manageWatchListPage.enterWatchListName(watchListName);
        Assert.assertTrue(manageWatchListPage.watchListNameAlreadyExistText.isDisplayed());
        if(EnvironmentVariable.getAvailableInstance().isAndroid()){
            utils.deviceBackKey();
        }else {
            manageWatchListPage.watchListNameAlreadyExistText.click();
        }

        watchListSize++;
        while (watchListSize < 10) {
            manageWatchListPage.createNewWatchlist();
            watchListSize++;
        }
        utils.scrollVerticallyTillElement(manageWatchListPage.maxWatchlistLimitText);
        Assert.assertTrue(manageWatchListPage.maxWatchlistLimitText.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Creating the watchlist Scenarios")
    @Test(description = "Verify user can create a new WL from Add to Watchlist bottom page", dataProvider = "watchlistAndStockSearchData", dataProviderClass = WatchListDataProvider.class)
    public void verifyCreateNewWLFromAddToWLPage(String searchData, String watchList) {
        ManageWatchListPage manageWatchListPage = new ManageWatchListPage();
        SearchPage searchPage = new SearchPage();
        NavigationHelper navigationHelper = new NavigationHelper();
        manageWatchListPage.deleteWatchlistFlowFromHomePage(navigationHelper, 3);
        manageWatchListPage.clickCrossButton();
        navigationHelper.goToSearchPage().bookMarkStock(searchData);
        utils.scrollVerticallyTillElement(manageWatchListPage.createNewWatchList);
        manageWatchListPage.createNewWatchlistFromBookMarkPage(watchList, searchPage);
        utils.deviceBackKey();
        WatchListPage watchListPage = navigationHelper.goToWatchList();
        watchListPage.setWatchlistName(watchList);
        utils.scrollHorizontallyTillElement(watchListPage.manageWatchListHamburger, watchListPage.watchListName);
        watchListPage.watchListName.setElementSync(true);
        watchListPage.watchListName.click();
        watchListPage.setWatchListStock(searchData);
        Assert.assertTrue(watchListPage.watchListStock.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Deleting the watchlist Scenarios")
    @Test(description = "Verify that the user can delete a Watchlist and confirm the deletion")
    public void verifyDeleteWatchListScenarios() {
        NavigationHelper navigationHelper = new NavigationHelper();
        ManageWatchListPage manageWatchListPage = new ManageWatchListPage();
        manageWatchListPage.deleteWatchlistFlowFromHomePage(navigationHelper, 1);
        Assert.assertFalse(manageWatchListPage.deleteWatchListIcon.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Ticks in the watchlist Scenarios")
    @Test(enabled = false, description = "Verify that the Last Traded Price (LTP), percentage change, and change in price are displayed in the Watchlist and are updated correctly at regular intervals")
    public void verifyLtpPerChangeSection() {
        //Later
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Sorting Options in Watchlist")
    @Test(enabled = false, description = "Verify that the sorting options in Watchlist work as expected")
    public void verifySortingOptionsFuntionality() {
        //Later
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Sorting Options in Watchlist")
    @Test(description = "Verify the availability of sorting options when there are no scrips in the Watchlist", dataProvider = "sortingOptionsWatchlist", dataProviderClass = WatchListDataProvider.class)
    public void verifySortingOptionsUnAvailability(String watchListName) {
        ManageWatchListPage manageWatchListPage = new ManageWatchListPage();
        NavigationHelper navigationHelper = new NavigationHelper();
        WatchListPage watchListPage = navigationHelper.goToWatchList();
        watchListPage.removeAllStocksFromWatchList(manageWatchListPage);
        Assert.assertFalse(watchListPage.sortButton.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Adding Stock to Watchlist ")
    @Test(description = "Verify Adding stocks from New WL Page with 'Add Stocks' Button", dataProvider = "keywordsForStocksSuggestion", dataProviderClass = WatchListDataProvider.class)
    public void verifyAddingStocksFromWLPage(String watchListName, List<String> keywords, String stock) {
        ManageWatchListPage manageWatchListPage = new ManageWatchListPage();
        WatchListPage watchListPage = new WatchListPage();
        NavigationHelper navigationHelper = new NavigationHelper();
        SearchPage searchPage = new SearchPage();
        manageWatchListPage.deleteWatchlistFlowFromHomePage(navigationHelper, 1);
        manageWatchListPage.createNewWatchlist(watchListName);
        manageWatchListPage.clickCrossButton();
        utils.loadUntilElementFound(watchListPage.manageWatchListHamburger);
        watchListPage.clickAddStocks();
        utils.waitForElementToDisplay(watchListPage.popularStocksText);
        Assert.assertTrue(watchListPage.popularStocksText.isDisplayed());
        watchListPage.verifyAddRemoveSuggestionStock(searchPage, watchListName);
        watchListPage.addAllStocksToWlFromSuggestion(searchPage, keywords);
        watchListPage.enterSearchBar(stock);
        utils.waitForElementToDisplay(searchPage.allTab);
//        utils.hideKeyboard();
        watchListPage.clickBookmarkIcon();
        utils.waitForElementToDisplay(watchListPage.maxScripLimitText);
        Assert.assertTrue(watchListPage.maxScripLimitText.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Editing a Watchlist")
    @Test(description = "Verify that the user can edit a Watchlist from Manage WatchList and verify Discard Popup", dataProvider = "updatedWatchlistData", dataProviderClass = WatchListDataProvider.class)
    public void verifyEditingWLFromManageWL(String updatedWatchListName) {
        EditWatchListPage editWatchListPage = new EditWatchListPage();
        NavigationHelper navigationHelper = new NavigationHelper();
        ManageWatchListPage manageWatchListPage = navigationHelper.goToWatchList().clickManageWatchList();
        String firstWatchList = manageWatchListPage.getFirstWlName();
        manageWatchListPage.clickEditFirstWL();
        utils.waitForElementToDisplay(editWatchListPage.editWatchListTitle);
        Assert.assertTrue(editWatchListPage.editWatchListTitle.isDisplayed());
        editWatchListPage.enterNewWatchListName(updatedWatchListName);
        editWatchListPage.deleteFirstStockFromEditPage();
        editWatchListPage.verifyDiscardChangesPopup();
        editWatchListPage.clickSavePopupButton();
        String updatedWl = manageWatchListPage.getFirstWlName();
        Assert.assertEquals(updatedWl, updatedWatchListName);
        manageWatchListPage.clickEditFirstWL();
        editWatchListPage.enterNewWatchListName(firstWatchList);
        editWatchListPage.verifyDiscardChangesPopup();
        editWatchListPage.clickDiscardPopupButton();
        utils.loadUntilElementFound(manageWatchListPage.watchListName);
        String notUpdatedWl = manageWatchListPage.watchListName.getElements().get(0).getText();
        Assert.assertNotEquals(notUpdatedWl, firstWatchList);
        manageWatchListPage.clickEditFirstWL();
        editWatchListPage.enterNewWatchListName(firstWatchList);
        editWatchListPage.clickSaveButton();
        String newUpdatedWl = manageWatchListPage.getFirstWlName();
        Assert.assertEquals(newUpdatedWl, firstWatchList);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the WatchList Scenarios")
    @Story("Validate Editing a Watchlist")
    @Test(description = "Verify user can Edit the WL from the Selected WL")
    public void verifyEditingWLFromSelectedWL() {
        NavigationHelper navigationHelper = new NavigationHelper();
        WatchListPage watchListPage = navigationHelper.goToWatchList();
        if (!watchListPage.manageWatchListHamburger.isDisplayed()) {
            watchListPage.clickAddStocks();
            utils.waitForElementToDisplay(watchListPage.popularStocksText);
            watchListPage.addFirstPopularStock();
            utils.deviceBackKey();
        }
        utils.scrollVerticallyTillElement(watchListPage.editWatchListButton);
        Assert.assertTrue(watchListPage.clickEditWatchlistButton().editWatchListTitle.isDisplayed());
    }
}
