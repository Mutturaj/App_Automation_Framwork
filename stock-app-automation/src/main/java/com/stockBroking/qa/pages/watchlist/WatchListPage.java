package com.stockBroking.qa.pages.watchlist;

import com.stockBroking.qa.pages.searchPage.SearchPage;
import com.stockBroking.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import listner.ThreadCreator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import java.util.List;

import static listner.ThreadCreator.getLocalDriver;

public class WatchListPage extends BasePage {
    private final TestUtils utils;

    public WatchListPage() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
        utils = new TestUtils();
    }

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "watchlist_header", name = "watchlist header")
    public Element header;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "watchlist_search", name = "Search Bar")
    public Element search;

    //Adding temporarily until the proper element is added
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]", name = "Search element")
    public Element searchElement;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.EditText", name = "Search Bar")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeTextField", name = "Search Bar")
    public Element searchBar;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "search", name = "Search icon")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "search", name = "Search icon")
    public Element searchIcon;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = " //*[contains(@text,'Add to ')]//parent::android.view.View", name = "Search Bar Input")
    public Element searchBarInput;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"%s\"]", name = "WatchList Name")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]", name = "WatchList Name")
    public Element watchListName;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@content-desc=\"%s\"]", name = "Watchlist Stock")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]", name = "Watchlist Stock")
    public Element watchListStock;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"Add to Watchlist\"]", name = "Add to Watchlist Button")
    public Element addToWatchListButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"EDIT WATCHLIST\"]/following-sibling::android.widget.Button", name = "Edit WatchList Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"EDIT WATCHLIST\"]", name = "Edit WatchList Button")
    public Element editWatchListButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"ADD STOCKS\"]/following-sibling::android.widget.Button", name = "Add WatchList Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"ADD STOCKS\"]", name = "Add WatchList Button")
    public Element addStocksButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"%s\"]/following-sibling::android.view.View/android.view.View[@content-desc=\"edit_watchlist_delete\"]", name = "Remove WatchList Stock")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]/following-sibling::XCUIElementTypeButton[@name=\"remove_circle\"]", name = "Remove WatchList Stock")
    public Element removeWatchListStock;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"SAVE\"]/following-sibling::android.widget.Button", name = "Save WatchList Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"SAVE\"]", name = "Save WatchList Button")
    public Element saveWatchListButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Changes saved successfully.\"]", name = "Changes Saved Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"Changes saved successfully.\"]", name = "Changes Saved Text")
    public Element allChangesSavedText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@content-desc=\"watchlist_edit_list\"]/ancestor::android.view.View/preceding-sibling::android.view.View)[last()]", name = "Manage Watchlist Hamburger")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "menu_watchlist", name = "Manage Watchlist Hamburger")
    public Element manageWatchListHamburger;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "watchlist_sort", name = "Sort Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Sort\"]", name = "Sort Button")
    public Element sortButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Sort By\"]", name = "Sort By Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Sort by\"]", name = "Sort By Heading")
    public Element sortByHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Name - A to Z\"]/preceding-sibling::android.view.View[@content-desc=\"radio\"]", name = "Name A-Z Sort")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Name - A to Z\"]/preceding-sibling::XCUIElementTypeImage[last()]", name = "Name A-Z Sort")
    public Element aToZSort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Name - Z to A\"]/preceding-sibling::android.view.View[@content-desc=\"radio\"]", name = "Name Z-A Sort")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Name - Z to A\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "Name Z-A Sort")
    public Element zToASort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"% Change - Low to High\"]", name = "% Change - Low to High Sort")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"% Change - Low to High\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "% Change - Low to High Sort")
    public Element percentChangeLowToHighSort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"% Change - High to Low\"]", name = "% Change - High to Low Sort")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"% Change - High to Low\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "% Change - High to Low Sort")
    public Element percentChangeHighToLowSort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Last Traded Price - Low to High\"]", name = "Last Traded Price - Low to High")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Last Traded Price - Low to High\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "Last Traded Price - Low to High")
    public Element ltpLowToHighSort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Last Traded Price - High to Low\"]", name = "Last Traded Price - High to Low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Last Traded Price - High to Low\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "Last Traded Price - High to Low")
    public Element ltpHighToLowSort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Custom\"]", name = "customSort")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Custom\"]/preceding-sibling::XCUIElementTypeImage[1]", name = "customSort")
    public Element customSort;
    // till here...
    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "manage", name = "Manage button")
    public Element manage;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "watchlist_edit_list", name = "Edit list")
    public Element editlist;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "watchlist_sort", name = "Sort")
    public Element sort;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc='Watchlist'])//parent::android.view.View", name = "click on watch list")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Watchlist", name = "click on watch list")
    public Element watchlistTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Popular Stocks\"]", name = "Popular Stocks Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Popular Stocks\"]", name = "Popular Stocks Text")
    public Element popularStocksText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"bookmark\"]", name = "Bookmark Icons")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"add_watchlist\"]", name = "Bookmark Icons")
    public Elements bookMarkIcons;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"bookmark\"]", name = "Bookmark Icon")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"add_watchlist\"]", name = "Bookmark Icon")
    public Element bookMarkIcon;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"You've reached the maximum scrip limit per Watchlist.\"]", name = "max Scrip Limit Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"You've reached the maximum scrip limit per Watchlist.\"]", name = "max Scrip Limit Text")
    public Element maxScripLimitText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,\"Successfully saved this scrip in\")]", name = "success save scrip")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"You've reached the maximum scrip limit per Watchlist.\"]", name = "success save scrip")
    public Element successfullySavedScrip;


    public void clickWatchListTab() {
        watchlistTab.setElementSync(true);
        watchlistTab.click();

    }

    public void clickAddStocks() {
        addStocksButton.setElementSync(true);
        addStocksButton.click();
    }

    public ManageWatchListPage clickManageWatchList() {
        if (!manageWatchListHamburger.isDisplayed()) {
            clickAddStocks();
            utils.waitForElementToDisplay(popularStocksText);
            addFirstPopularStock();
            utils.deviceBackKey();
        }
        utils.waitForElementToDisplay(searchIcon);
        utils.loadUntilElementFound(manageWatchListHamburger);
        manageWatchListHamburger.setElementSync(true);
        manageWatchListHamburger.click();
        return new ManageWatchListPage();
    }

    public void searchStockAndSelect(String stockValue) {
        searchIcon.loadElement();
        searchIcon.click();
        Actions action = new Actions(getLocalDriver());
        searchBarInput.loadElement();
        action.sendKeys(stockValue);
        action.perform();
        searchElement.click();
    }

    public void setWatchListStock(String stockName) {
        watchListStock.setMobileRegex(new String[]{stockName});
        watchListStock.loadElement();
    }

    public void setWatchlistName(String watchlist) {
        watchListName.setMobileRegex(new String[]{watchlist});
    }

    public void removeWatchListStock(String stockName, String watchList) {
        clickWatchListTab();
        setWatchlistName(watchList);
        if (watchListName.isDisplayed()) {
            watchListName.click();
            setWatchListStock(stockName);
            if (watchListStock.isDisplayed()) {
                editWatchListButton.click();
                removeWatchListStock.setMobileRegex(new String[]{stockName});
                removeWatchListStock.click();
                saveWatchListButton.click();
                utils.waitForElementToDisplay(allChangesSavedText);
                Assert.assertTrue(allChangesSavedText.isDisplayed());
            }
        }
    }

    public void removeAllStocksFromWatchList(ManageWatchListPage manageWatchListPage) {
        utils.scrollVerticallyTillElement(editWatchListButton);
        if (editWatchListButton.isDisplayed()) {
            editWatchListButton.click();
            int stocksCount = manageWatchListPage.deleteIcons.getElements().size();
            while (stocksCount > 0) {
                manageWatchListPage.deleteIcons.loadElements();
                Element stockDelete = manageWatchListPage.deleteIcons.getElements().get(--stocksCount);
                stockDelete.setElementSync(true);
                stockDelete.click();
                if (stocksCount == 1) {
                    stocksCount = updateDeleteIconsCount(manageWatchListPage);
                }
            }
            saveWatchListButton.click();
            utils.loadUntilElementFound(allChangesSavedText);
            Assert.assertTrue(allChangesSavedText.isDisplayed());
        }
    }

    public int updateDeleteIconsCount(ManageWatchListPage manageWatchListPage) {
        manageWatchListPage.deleteIcons.loadElements();
        return manageWatchListPage.deleteIcons.getElements().size();
    }

    public void enterSearchBar(String value) {
        searchBar.setElementSync(true);
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(value);
    }

    public void clickBookmarkIcon() {
        bookMarkIcon.loadElement();
        bookMarkIcon.setElementSync(true);
        bookMarkIcon.click();
    }

    public void addAllStocksToWlFromSuggestion(SearchPage searchPage, List<String> keywords) {
        int stockCount = 0;
        outerLoop:
        for (String key : keywords) {
            enterSearchBar(key);
            utils.waitForElementToDisplay(searchPage.allTab);
//                utils.hideKeyboard();
            bookMarkIcons.loadElements();
            List<Element> bookmarkIconsList = bookMarkIcons.getElements();
            System.out.println(bookmarkIconsList.size());
            for (Element bookmark : bookmarkIconsList) {
                utils.waitForElementToDisplay(bookmark);
                bookmark.setElementSync(true);
                bookmark.click();
                stockCount++;
                if (stockCount % 9 == 0)
                    break;
                if (stockCount == 50)
                    break outerLoop;
            }
        }
    }

    public void verifyAddRemoveSuggestionStock(SearchPage searchPage, String watchListName) {
        clickBookmarkIcon();
        searchPage.setSuccessfullySavedScripText(watchListName);
        utils.waitForElementToDisplay(searchPage.successfullySavedScripText);
        Assert.assertTrue(utils.isPresent(searchPage.successfullySavedScripText));
        bookMarkIcon.loadElement();
        bookMarkIcon.click();
        searchPage.setSuccessfullyRemovedScripText(watchListName);
        utils.waitForElementToDisplay(searchPage.successfullyRemovedScripText);
        Assert.assertTrue(utils.isPresent(searchPage.successfullyRemovedScripText));
    }

    public void addFirstPopularStock() {
        bookMarkIcon.loadElement();
        clickBookmarkIcon();
        utils.waitForElementToDisplay(successfullySavedScrip);
        Assert.assertTrue(successfullySavedScrip.isDisplayed());
    }

    public EditWatchListPage clickEditWatchlistButton() {
        editWatchListButton.click();
        return new EditWatchListPage();
    }

}

