package com.stockBroking.qa.appTests.orderFlowTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.dataprovider.BuySellDataProvider;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.NavigationHelper;
import com.stockBroking.qa.utils.TestUtils;
import com.stockBroking.qa.validators.buySellVerifier.BuySellPageVerifier;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.pages.orderFlow.OrderPage;

import java.io.IOException;

public class BuySellTest extends ShareMarketBaseTest {

    private final TestUtils utils;
    private final LoginHelpers loginHelpers;
    private final Helper helper;
    private final BuySellPageVerifier buySellPageVerifier;

    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException, JSONException {
        LoginPage loginPage = new LoginPage();
        if (loginPage.useYourPhonePeAccText.isDisplayed()) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        } else if (loginPage.pinField.isDisplayed()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
    }

    BuySellTest() {
        this.utils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.helper = new Helper();
        this.buySellPageVerifier = new BuySellPageVerifier();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY Order")
    @Test(description = "Validate user placing BUY - Market order with Validity Set to Day", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyDeliveryMarketDayValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.buyStockText.setMobileRegex(new String[]{searchData});
        buySellPageVerifier.defaultBuyPageVerifier(orderPage, utils);
        buySellPageVerifier.placeOrderErrorTextVerifier(orderPage);
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY Order")
    @Test(description = "Validate user placing BUY - Market order with Validity Set to IOC", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyDeliveryMarketIOCValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.clickAdvancedDropdown();
        orderPage.clickValidityDropdown();
        buySellPageVerifier.defaultValidityDropdownVerifier(orderPage, utils);
        orderPage.selectIOCValidity();
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY Order")
    @Test(enabled = false, description = "Validate user placing BUY -  Conditional Market order - SLM with Validity : IOC", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyDeliverySLMIOCValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.clickOrderTypeDropdown();
        buySellPageVerifier.defaultOrderTypeDropdownVerifier(orderPage, utils);
        orderPage.clickCondtionalMarketOrderType();
        Assert.assertTrue(orderPage.triggerPriceField.isDisplayed());
        orderPage.clickAdvancedDropdown();
        orderPage.clickValidityDropdown();
        orderPage.selectIOCValidity();
        buySellPageVerifier.placeConditionalOrderErrorTextVerifier(orderPage, utils);
        orderPage.enterTriggerPrice();
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());
        //Later Automate
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY Order")
    @Test(description = "Validate user placing BUY -  Conditional Limit order - SL", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyDeliverySLDayValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.clickOrderTypeDropdown();
        orderPage.clickConditionalLimitOrder();
        Assert.assertTrue(orderPage.triggerPriceField.isDisplayed());
        Assert.assertTrue(orderPage.limitPriceField.isDisplayed());
        orderPage.clickAdvancedDropdown();
        buySellPageVerifier.placeConditionalLimitOrderErrorTextVerifier(orderPage, utils);
        orderPage.enterTriggerPrice();
        orderPage.enterLimitPrice();
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());
        //Later Automate
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY order")
    @Test(enabled = false, description = "Validate user placing BUY -  Intraday  Conditional Market order - SLM  with Validity : IOC", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyIntradaySLMIOCValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.clickIntraday();
        orderPage.clickOrderTypeDropdown();
        orderPage.clickCondtionalMarketOrderType();
        Assert.assertTrue(orderPage.triggerPriceField.isDisplayed());
        orderPage.clickAdvancedDropdown();
        orderPage.clickValidityDropdown();
        orderPage.selectIOCValidity();
        buySellPageVerifier.placeConditionalOrderErrorTextVerifier(orderPage,utils);
        orderPage.enterTriggerPrice();
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());

        //Later Automate
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Buy-sell(Cash Segment) Scenarios")
    @Story("Verify User placing BUY order")
    @Test(description = "Validate user placing BUY -  Intraday  Conditional Limit order - SL", dataProvider = "BuySellData", dataProviderClass = BuySellDataProvider.class)
    public void verifyBuyIntradaySLDayValidity(String searchData) {
        NavigationHelper navigationHelper = new NavigationHelper();
        OrderPage orderPage = navigationHelper.goToSearchPage().searchAndSelect(searchData).clickBuyButton();
        orderPage.clickIntraday();
        orderPage.clickOrderTypeDropdown();
        orderPage.clickConditionalLimitOrder();
        Assert.assertTrue(orderPage.triggerPriceField.isDisplayed());
        Assert.assertTrue(orderPage.limitPriceField.isDisplayed());
        orderPage.clickAdvancedDropdown();
        buySellPageVerifier.placeConditionalLimitOrderErrorTextVerifier(orderPage, utils);
        orderPage.enterTriggerPrice();
        orderPage.enterLimitPrice();
        orderPage.enterQuantity();
        orderPage.clickPlaceOrderButton();
        utils.waitForElementToDisplay(orderPage.onboardingScreenText);
        Assert.assertTrue(orderPage.onboardingScreenText.isDisplayed());
        //Later Automate
    }
}
