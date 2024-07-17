package com.stockBroking.qa.pages.watchlist;

import com.stockBroking.qa.pages.searchPage.SearchPage;
import com.stockBroking.qa.utils.NavigationHelper;
import com.stockBroking.qa.utils.TestUtils;
import listner.ThreadCreator;
import org.apache.commons.lang3.RandomStringUtils;
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

public class ManageWatchListPage extends BasePage {

    private final TestUtils utils;


    public ManageWatchListPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
        utils = new TestUtils();
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"delete\"]/following-sibling::android.widget.Button", name = "Delete watchlist Icons")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name=\"remove_circle\"]", name = "Delete watchlist Icons")
    public Elements deleteIcons;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"delete\"]/following-sibling::android.widget.Button", name = "Delete watchlist Icon")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"remove_circle\"])[1]", name = "Delete watchlist Icon")
    public Element deleteWatchListIcon;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"Reorder\"]/following-sibling::android.widget.TextView", name = "WatchList Name")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name=\"manage_rearrange\"]/following-sibling::XCUIElementTypeStaticText", name = "WatchList Name")
    public Elements watchListName;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"manage_watchlist_add_new\"]/following-sibling::android.widget.Button", name = "Create new Watchlist Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"CREATE NEW WATCHLIST\"]", name = "Create new Watchlist Button")
    public Element createNewWatchList;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@content-desc=\"add_watchlist_header\"][@text=\"Create New Watchlist\"]", name = "Create new Watchlist Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Create New Watchlist\"]", name = "Create new Watchlist Heading")
    public Element createNewWatchListHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Delete %s?\"]/following-sibling::android.widget.TextView[@text=\"This action will remove your %s watchlist\"]", name = "Delete Watchlist Text")
    public Element deleteWatchListText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text, \"Delete \")]", name = "Delete Watchlist Popup Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name,\"Delete \")]", name = "Delete Watchlist Popup Text")
    public Element deleteWatchListPopupText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text, \"action \")]", name = "Delete Watchlist Popup SubText")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name, \"action \")]", name = "Delete Watchlist Popup SubText")
    public Element deleteWatchListPopupSubText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"DELETE\"]/preceding-sibling::android.view.View", name = "Delete Watchlist Button Popup")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "DELETE", name = "Delete Watchlist Button Popup")
    public Element deleteWatchlistButtonPopup;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"CANCEL\"]/preceding-sibling::android.view.View", name = "Cancel Watchlist Button Popup")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "CANCEL", name = "Cancel Watchlist Button Popup")
    public Element cancelWatchlistButtonPopup;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,\"successfully deleted \")]", name = "Successfully Deleted WatchList Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[contains(@text,\"Watchlist deleted succesfully\")]", name = "Successfully Deleted WatchList Text")
    public Element successfullyDeletedWatchListText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"edit\"]", name = "Edit WatchList")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name=\"edit\"]", name = "Edit WatchList")
    public Elements editWatchListButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Manage Watchlist\"]", name = "Manage watchlist")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Manage Watchlist", name = "Manage watchlist")
    public Element manageWatchlistHeading;

    //    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "", name = "Manage watchlist header")
//    public Element header;
//    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "", name = "Mangae watchlist Name")
//    public Element listName;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = " //android.view.View[@content-desc='delete']//parent::android.view.View", name = "Delte list button")
    public Element deletlist;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='edit']//parent::android.view.View", name = "Edit button")
    public Element editbutton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "android.view.View[@content-desc='Add']//parent::android.view.View", name = "Add New Watchlist")
    public Element Addbutton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "navigation icon", name = "Backkey")
    public Element navigation;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "/android.widget.TextView[@content-desc='add_watchlist_header']//parent::android.view.View", name = "Custom list header")
    public Element customListheader;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='add_watchlist_text']//parent::android.widget.EditText", name = "Custom list text box")
    public Element customListText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='add_watchlist_add']//parent::android.view.View", name = "Custom list add button")
    public Element customListAddButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@content-desc=\"add_watchlist_header\"][@text=\"Create New Watchlist\"]", name = "Create New WatchList Header")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Create New Watchlist\"]", name = "Create New WatchList Header")
    public Element createNewWatchListHeader;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"add_watchlist_add\"]/following-sibling::android.widget.Button", name = "Create Now Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"CREATE NOW\"]", name = "Create Now Button")
    public Element createNowButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"add_watchlist_text\"]/android.widget.EditText", name = "Enter Watchlist Name")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Create New Watchlist\"]/following-sibling::XCUIElementTypeTextField", name = "Enter Watchlist Name")
    public Element enterWatchListNameField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"snackbar image description\"]/following-sibling::android.widget.TextView[@text=\"Successfully created watchlist\"]", name = "Successfully Created Watchlist Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[contains(@text,\"added Successfully\")]", name = "Successfully Created Watchlist Text")
    public Element successfullWatchListCreatedText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"This watchlist name already exists\"]", name = "Watchlist name already exists")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"This watchlist name already exists\"]", name = "Watchlist name already exists")
    public Element watchListNameAlreadyExistText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text =\"You've reached the maximum Watchlist limit.\"]", name = "Max Watchlist limit reached")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Reached the maximum watchlist limit 10/10\"]", name = "Max Watchlist limit reached")
    public Element maxWatchlistLimitText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Manage Watchlist\"]/preceding-sibling::android.widget.Button", name = "Cross Button Manage Watchlist")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"close\"]", name = "Cross Button Manage Watchlist")
    public Element crossButtonManageWatchList;

    public void clickCrossButton() {
        utils.loadUntilElementFound(crossButtonManageWatchList);
        crossButtonManageWatchList.setElementSync(true);
        crossButtonManageWatchList.click();
    }

    public void clickEditButton() {
        editbutton.click();
    }

    public void clickAddButton() {
        Addbutton.click();
    }

    public void clickBackKey() {
        navigation.click();
    }

//    public String verifyPageHeader() {
//        return header.getText();
//    }
//
//    public String verifyListName() {
//        return listName.getText();
//    }

    public String customListHeading() {
        return customListheader.getText();
    }

    public void addListName(String Name) {
        customListText.sendKeys(Name);
    }

    public void clickAddListTextBox() {
        customListText.click();
    }

    public void clickAddCustomList() {
        customListAddButton.click();
    }

    public boolean addListButton() {
        return customListAddButton.isEnabled();
    }

    public void clickCreateNewWatchListButton() {
        createNewWatchList.loadElement();
        createNewWatchList.setElementSync(true);
        createNewWatchList.click();
    }

    public void enterWatchListName(String watchListName) {
        createNewWatchListHeading.loadElement();
        utils.waitForElementToDisplay(createNewWatchListHeading);
        utils.waitForElementToDisplay(createNowButton);
        createNewWatchListHeading.loadElement();
        Assert.assertTrue(createNewWatchListHeading.isDisplayed());
        enterWatchListNameField.loadElement();
        enterWatchListNameField.setElementSync(true);
        enterWatchListNameField.click();
        enterWatchListNameField.clear();
        enterWatchListNameField.sendKeys(watchListName);
    }

    public void clickCreateNowButton() {
        createNowButton.loadElement();
        createNowButton.setElementSync(true);
        createNowButton.click();
    }

    public void createNewWatchlist() {
        String watchListName = "WatchList " + RandomStringUtils.random(4, false, true);
        createNewWatchlist(watchListName);
    }

    public void createNewWatchlist(String watchListName) {
        clickCreateNewWatchListButton();
        enterWatchListName(watchListName);
        clickCreateNowButton();
        utils.waitForElementToDisplay(manageWatchlistHeading);
        successfullWatchListCreatedText.loadElement();
        Assert.assertTrue(successfullWatchListCreatedText.isDisplayed());
    }

    public void createNewWatchlistFromBookMarkPage(String watchListName, SearchPage searchPage) {
        clickCreateNewWatchListButton();
        enterWatchListName(watchListName);
        clickCreateNowButton();
        searchPage.successfullySavedScripText.setMobileRegex(new String[]{watchListName});
        Assert.assertTrue(utils.isPresent(searchPage.successfullySavedScripText));
    }

    public void deleteWatchList(Element deleteIcon, String watchListName) {
        deleteIcon.setElementSync(true);
        deleteIcon.click();
        utils.waitForElementToDisplay(deleteWatchlistButtonPopup);
        deleteWatchListPopupText.loadElement();
        deleteWatchListPopupSubText.loadElement();
        Assert.assertTrue(deleteWatchListPopupText.getText().contains(watchListName));
        Assert.assertTrue(deleteWatchListPopupSubText.getText().contains(watchListName));
        deleteWatchlistButtonPopup.loadElement();
        deleteWatchlistButtonPopup.click();
        int count = 0;
        do {
            successfullyDeletedWatchListText.loadElement();

        }
        while (!utils.isPresent(successfullyDeletedWatchListText) && count++ < 10);
        Assert.assertTrue(successfullyDeletedWatchListText.getText().contains(watchListName));
        utils.waitForElementToBeInvisible(successfullyDeletedWatchListText);
    }

    public void deleteWatchlistFlowFromHomePage(NavigationHelper navigationHelper, int threshold) {
        navigationHelper.goToWatchList().clickManageWatchList();
        utils.waitForElementToDisplay(manageWatchlistHeading);
        int watchListSize = deleteIcons.getElements().size();
        while (watchListSize > threshold) {
            deleteIcons.loadElements();
            watchListName.loadElements();
            watchListSize = deleteIcons.getElements().size();
            String watchList = watchListName.getElements().get(--watchListSize).getText();
            deleteWatchList(deleteIcons.getElements().get(watchListSize), watchList);
        }
    }

    public void clickEditFirstWL() {
        editWatchListButton.loadElements();
        Element firstWLEditButton = editWatchListButton.getElements().get(0);
        firstWLEditButton.loadElement();
        firstWLEditButton.setElementSync(true);
        firstWLEditButton.click();
    }

    public String getFirstWlName() {
        watchListName.loadElements();
        return watchListName.getElements().get(0).getText();
    }
}
