package com.stockBroking.qa.pages.searchPage;

import com.stockBroking.qa.pages.scripDetails.ChartsPage;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.TestUtils;
import listner.ThreadCreator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;
import java.util.*;

public class SearchPage extends BasePage {
    Helper helper;
    private TestUtils utils;

    public SearchPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
        utils = new TestUtils();
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Search for Stocks, ETFs, and more\"]/ancestor::android.widget.EditText", name = "Global And Local Search Bar")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeTextField[@value=\"Search for Stocks, ETFs, and more\"]", name = "Global And Local Search Bar")
    public Element searchField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"All\"]/following-sibling::android.widget.TextView[@text=\"All\"]", name = "All Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"All\"]", name = "All Tab")
    public Element allTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"Stocks\"]/following-sibling::android.widget.TextView[@text=\"Stocks\"]", name = "Stocks Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Stocks\"]", name = "Stocks Tab")
    public Element stocksTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"ETF\"]/following-sibling::android.widget.TextView[@text=\"ETF\"]", name = "ETF Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"ETF\"]", name = "ETF Tab")
    public Element etfTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"Index\"]/following-sibling::android.widget.TextView[@text=\"Index\"]", name = "Index Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Index\"]", name = "Index Tab")
    public Element indexTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"bookmark\"]/parent::android.view.View/preceding-sibling::android.widget.TextView/preceding-sibling::android.widget.TextView", name = "Tab List Items")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"add_watchlist\"]/preceding-sibling::XCUIElementTypeStaticText[1]/preceding-sibling::XCUIElementTypeStaticText[1]", name = "Tab List Items")
    public Elements tabListItems;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"No Results found for %s\"]", name = "No results found")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='No results found for \"%s\"']", name = "No results found")
    public Element noResultFoundText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"%s\"]", name = "Stock Search Result")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]", name = "Stock Search Result")
    public Element stockSearchedResult;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"%s\"]/following-sibling::android.view.View/android.widget.Button", name = "Stock Search Bookmark Icon")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]/following-sibling::XCUIElementTypeButton[@name=\"add_watchlist\"][1]", name = "Stock Search Bookmark Icon")
    public Element stockSearchedBookmarkIcon;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Add to Watchlist\"]/following-sibling::android.widget.TextView[@text=\"Select watchlists to add this stock to\"]", name = "Add to watchlist Popup")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Add to Watchlist\"]/following-sibling::XCUIElementTypeStaticText[@name=\"Select the watchlist you would like to add this scrip to\"]", name = "Add to watchlist Popup")
    public Element addToWatchListPopup;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"My First List\"]/following-sibling::android.view.View[@content-desc=\"selector\"]", name = "Add to watchlist Checkbox")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"My First List\"]/following-sibling::XCUIElementTypeImage[@name=\"checkbox_unchecked\"]", name = "Add to watchlist Checkbox")
    public Element addToWatchListCheckbox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"SAVE\"]/following-sibling::android.widget.Button", name = "Save WatchList Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"SAVE\"]", name = "Save WatchList Button")
    public Element saveWatchListButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"All changes saved successfully!\"]", name = "All Changes Saved Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"All changes saved successfully!\"]", name = "All Changes Saved Text")
    public Element allChangesSavedText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Successfully saved this scrip in %s\"]", name = "Succesfully saved this scrip Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"Successfully saved this scrip in %s\"]", name = "Succesfully saved this scrip Text")
    public Element successfullySavedScripText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Successfully removed this scrip from %s\"]", name = "Succesfully removed this scrip Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"Successfully removed this scrip from %s\"]", name = "Succesfully removed this scrip Text")
    public Element successfullyRemovedScripText;

    public void setNoresultFoundText(String stockName) {
        noResultFoundText.setMobileRegex(new String[]{stockName});
    }

    public void setSuccessfullySavedScripText(String watchlist) {
        successfullySavedScripText.setMobileRegex(new String[]{watchlist});
    }

    public void setSuccessfullyRemovedScripText(String watchlist) {
        successfullyRemovedScripText.setMobileRegex(new String[]{watchlist});
    }

    public void setStockName(String stockName) {
        stockSearchedResult.setMobileRegex(new String[]{stockName});
    }

    public void bookMarkStock(String searchData) {
        enterSearchData(searchData);
        clickBookmarkIcon(searchData);
        utils.waitForElementToDisplay(addToWatchListPopup);
        Assert.assertTrue(addToWatchListPopup.isDisplayed());
    }

    public void clickBookmarkIcon(String stockName) {
        stockSearchedBookmarkIcon.setMobileRegex(new String[]{stockName});
        stockSearchedBookmarkIcon.setElementSync(true);
        stockSearchedBookmarkIcon.click();
    }

    public void enterSearchData(String searchData) {
        searchField.setElementSync(true);
        searchField.click();
        searchField.clear();
        searchField.sendKeys(searchData);
    }

    public ChartsPage searchAndSelect(String searchData) {
        enterSearchData(searchData);
        setStockName(searchData);
        stockSearchedResult.setElementSync(true);
        stockSearchedResult.click();
        return new ChartsPage();
    }

    public void clickAllTab() {
        allTab.click();
    }

    public void clickStocksTab() {
        stocksTab.click();
    }

    public void clickEtfTab() {
        etfTab.click();
    }

    public void clickIndexTab() {
        indexTab.click();
    }

    public void clickAddToWatchListCheckbox() {
        addToWatchListCheckbox.setElementSync(true);
        addToWatchListCheckbox.click();
    }

    public void clickSaveWatchListButton() {
        saveWatchListButton.click();
    }

    public boolean compareLists(List<String> expected, List<String> actual) {
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void verifyTabListItems(String searchData, List tabItems) {
        tabListItems.loadElements();
        if (tabListItems.getElements().size() > 0) {
            List<Element> allTabItems = tabListItems.getElements();
            List<String> tabList = new ArrayList<String>();
            for (WebElement item : allTabItems) {
                tabList.add(item.getAttribute("text"));
            }
            Collections.sort(tabList);
            Collections.sort(tabItems);
            Assert.assertTrue(tabList.containsAll(tabItems));
        } else {
            setNoresultFoundText(searchData);
            Assert.assertTrue(noResultFoundText.isDisplayed());
        }
    }

    public void verifyEtfTab(String searchData) {
        tabListItems.loadElements();
        if (tabListItems.getElements().size() > 0) {
            List<Element> allTabItems = tabListItems.getElements();
            for (WebElement item : allTabItems) {
                Assert.assertTrue(item.getAttribute("text").contains("ETF"));
            }
        } else {
            setNoresultFoundText(searchData);
            Assert.assertTrue(noResultFoundText.isDisplayed());
        }
    }


    public void verifyDifferentSearchData(String searchData) {
        tabListItems.loadElements();
        if (tabListItems.getElements().size() > 0) {
            List<Element> allTabItems = tabListItems.getElements();
            String firstSearchResult = allTabItems.get(0).getAttribute("text");
            Assert.assertTrue(firstSearchResult.contains(searchData));
        } else {
            setNoresultFoundText(searchData);
            Assert.assertTrue(noResultFoundText.isDisplayed());
        }
    }
}
