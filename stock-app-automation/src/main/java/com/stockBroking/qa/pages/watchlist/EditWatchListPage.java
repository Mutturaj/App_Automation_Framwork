package com.stockBroking.qa.pages.watchlist;

import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class EditWatchListPage extends BasePage {
    private TestUtils utils;

    public EditWatchListPage() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
        utils = new TestUtils();
    }

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "edit_watchlist_save", name = "Save Button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "SAVE", name = "Save Button")
    public Element saveButton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "edit_watchlist_title", name = "Edit Watchlist title")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Edit Watchlist title")
    public Element editWatchListTitle;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "edit_watchlist_close", name = "Cross Button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "close", name = "Cross Button")
    public Element crossButtonEditWatchList;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"edit_watchlist_text\"]/android.widget.EditText", name = "WatchListField")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Watchlist Name\"]/following-sibling::XCUIElementTypeTextField", name = "WatchListField")
    public Element watchListField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"edit_watchlist_delete\"]", name = "Delete Stock Icons")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"remove_circle\"]", name = "Delete Stock Icons")
    public Elements stockDeleteIcons;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Discard Changes?\"]", name = "Discard Changes popup?")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Discard the changes you made?\"]", name = "Discard Changes popup?")
    public Element discardChanges;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"DISCARD\"]", name = "Discard popup button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"DISCARD\"]", name = "Discard popup button")
    public Element discardPopupButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"SAVE\"]", name = "Save popup button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"SAVE\"]", name = "Save popup button")
    public Element savePopupButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Changes saved successfully.\"]", name = "Changes Saved Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@name=\"All changes saved successfully!\"]", name = "Changes Saved Text")
    public Element changesSavedText;

    public void enterNewWatchListName(String updatedWatchListName) {
        utils.loadUntilElementFound(watchListField);
        watchListField.setElementSync(true);
        watchListField.click();
        watchListField.clear();
        watchListField.sendKeys(updatedWatchListName);
    }

    public void deleteFirstStockFromEditPage() {
        Element firstStock = stockDeleteIcons.getElements().get(0);
        firstStock.setElementSync(true);
        firstStock.click();
    }

    public void verifyDiscardChangesPopup() {
        crossButtonEditWatchList.loadElement();
        crossButtonEditWatchList.setElementSync(true);
        crossButtonEditWatchList.click();
        utils.waitForElementToDisplay(discardChanges);
        discardChanges.loadElement();
        discardPopupButton.loadElement();
        savePopupButton.loadElement();
        Assert.assertTrue(discardChanges.isDisplayed());
        Assert.assertTrue(discardPopupButton.isDisplayed());
        Assert.assertTrue(savePopupButton.isDisplayed());
    }

    public void clickSavePopupButton() {
        savePopupButton.click();
        utils.waitForElementToDisplay(changesSavedText);
        Assert.assertTrue(changesSavedText.isDisplayed());
    }

    public void clickDiscardPopupButton() {
        discardPopupButton.loadElement();
        discardPopupButton.click();
        changesSavedText.loadElement();
        Assert.assertFalse(changesSavedText.isDisplayed());
    }

    public void clickSaveButton() {
        saveButton.loadElement();
        saveButton.setElementSync(true);
        saveButton.click();
        utils.loadUntilElementFound(changesSavedText);
        Assert.assertTrue(changesSavedText.isDisplayed());
    }
}
