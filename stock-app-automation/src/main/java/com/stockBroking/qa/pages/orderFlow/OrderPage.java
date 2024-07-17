package com.stockBroking.qa.pages.orderFlow;

import com.stockBroking.qa.model.BuySell;
import com.stockBroking.qa.utils.TestUtils;
import listner.ThreadCreator;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

public class OrderPage extends BasePage {

    private final TestUtils utils;

    public OrderPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
        utils = new TestUtils();
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='BUY']", name = "Start BUY button")
    public Element initBuyButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='SELL']", name = "Start SELL button")
    public Element initSellButton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Delivery", name = "Delivery button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Delivery", name = "Delivery button")
    public Element deliveryButton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Intraday", name = "Intraday button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Intraday", name = "Intraday button")
    public Element intradayButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,'Order')]/following-sibling::android.view.View/android.widget.TextView", name = "Order type")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name,'Order')]/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText", name = "Order type")
    public Element orderType;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc='selector'])[1]", name = "Order dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name='chevron_accordian_down'])[1]", name = "Order dropdown")
    public Element orderTypeDropdown;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Limit Price']//following-sibling::android.widget.EditText", name = "LimitPrice")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Limit Price']/following-sibling::XCUIElementTypeTextField[1]", name = "LimitPrice")
    public Element limitPrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Trigger Price (condition)']//following-sibling::android.widget.EditText", name = "TriggerPrice")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Trigger Price (condition)']//following-sibling::XCUIElementTypeTextField[1]", name = "TriggerPrice")
    public Element triggerPrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,'Quantity')]/following-sibling::android.widget.EditText | //android.widget.TextView[contains(@text,'Quantity')]/parent::android.view.View/following-sibling::android.widget.EditText", name = "Quantity Field")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[contains(@name,'Quantity')]/following-sibling::XCUIElementTypeTextField[1]", name = "Quantity Field")
    public Element qtyField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,'Available Margin')]", name = "Available Margin")
    public Element availableMargin;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "com.android.permissioncontroller:id/permission_allow_button", name = "Required Margin")
    public Element requiredMargin;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Advanced Options']", name = "Advanced options")
    public Element advancedOptionButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Validity']/following-sibling::android.view.View/android.widget.TextView", name = "Validity")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Validity']/following-sibling::XCUIElementTypeButton[1]/XCUIElementTypeStaticText", name = "Validity")
    public Element validity;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Validity']/following-sibling::android.view.View/android.view.View[@content-desc='selector']", name = "Validity dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Validity']/following-sibling::XCUIElementTypeButton[1]/XCUIElementTypeImage[@name='chevron_accordian_down']", name = "Validity dropdown")
    public Element validityDropdown;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Disclosed quantity']/following-sibling::android.view.View/android.widget.TextView", name = "Disclosed quantity")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Disclosed Quantity']/following-sibling::XCUIElementTypeButton[1]/XCUIElementTypeStaticText", name = "Disclosed quantity")
    public Element disclosedQty;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Disclosed quantity']/following-sibling::android.view.View/android.view.View[@content-desc='selector']", name = "Disclosed quantity dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Disclosed quantity']/following-sibling::XCUIElementTypeButton[1]/XCUIElementTypeImage[@name='chevron_accordian_down']", name = "Disclosed quantity dropdown")
    public Element disclosedQtyDropdown;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Buy']//following-sibling::android.widget.Button", name = "BUY button")
    public Element buyButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Sell']//following-sibling::android.widget.Button", name = "SELL button")
    public Element sellButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='PLACE ORDER']", name = "Place Order button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='PLACE ORDER']", name = "Place Order button")
    public Element placeOrderButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Order Placed']", name = "Place Order message")
    public Element placeOrderMessage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='BUY']/following-sibling::android.widget.TextView[@text='%s']", name = "Buy Stock Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='BUY']/following-sibling::XCUIElementTypeStaticText[@name='%s']", name = "Buy Stock Text")
    public Element buyStockText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Product type']", name = "Product Type Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Product type']", name = "Product Type Text")
    public Element productTypeText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Order type']", name = "Order Type Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Order type']", name = "Order Type Text")
    public Element orderTypeText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Quantity']/following-sibling::android.view.View[@content-desc='selector']", name = "Quanity Dropdown")
    public Element qtyDropdown;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Chart']", name = "Charts Toggle")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Chart']", name = "Charts Toggle")
    public Element chartsToggle;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Depth']", name = "Depth Toggle")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Depth']", name = "Depth Toggle")
    public Element depthToggle;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Total']", name = "Depth Toggle Total")
    public Element totalColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='NSE']", name = "NSE Switch")
    public Element nseSwitch;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='BSE']", name = "BSE Switch")
    public Element bseSwitch;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Switch Exchange", name = "Switch Exchange")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "sort_updown_neutral", name = "Switch Exchange")
    public Element switchExchange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,'Available: ₹')]", name = "Available Funds")
    public Element availableFunds;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,'Estd margin:')]", name = "Estimated Margin")
    public Element estdMargin;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Advanced Options']/following-sibling::android.view.View[@content-desc='drop down']", name = "Advanced Option Dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Additional Options']/following-sibling::XCUIElementTypeImage[@name='chevron_accordian_down']", name = "Advanced Option Dropdown")
    public Element advancedOptionDropdown;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Qty should be greater than 0']", name = "Quantity Error Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Qty should be greater than 0']", name = "Quantity Error Text")
    public Element qtyErrorText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text, 'Please enter trigger price')]", name = "Trigger Price Error Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name,'Please enter trigger price')]", name = "Trigger Price Error Text")
    public Element triggerPriceErrorText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text, 'Please enter limit price')]", name = "Limit Price Error Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name, 'Please enter limit price')]", name = "Limit Price Error Text")
    public Element limitPriceErrorText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Validity']/following-sibling::android.widget.TextView[@text='Choose how long you want your order to be valid']", name = "Validity Dropdown Header")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Validity']/following-sibling::XCUIElementTypeStaticText[@name='Choose your preferred order validity']", name = "Validity Dropdown Header")
    public Element validityDropdownHeader;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Day']", name = "Day Validity Dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Day']/following-sibling::XCUIElementTypeStaticText[@name='Order will be valid for the entire day']", name = "Day Validity Dropdown")
    public Element dayValidity;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='IOC - Immediate or Cancel']", name = "IOC Validity Dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='IOC - Immediate or Cancel']/following-sibling::XCUIElementTypeStaticText[@name='Order will cancel if it doesn’t get completely executed immediately']", name = "IOC Validity Dropdown")
    public Element iocValidity;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='selected']/preceding-sibling::android.widget.TextView/preceding-sibling::android.widget.TextView", name = "Validity Selected")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"Selected\"]/preceding-sibling::XCUIElementTypeStaticText/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Validity Selected")
    public Element validitySelected;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Order Type']/following-sibling::android.widget.TextView[@text='Choose your desired order type']", name = "Order Type Header")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Order type']/following-sibling::XCUIElementTypeStaticText[@name='Choose your desired order type from the list below']", name = "Order Type Header")
    public Element orderTypeDropdownHeader;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Market order']", name = "Market Order Dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Market Order']", name = "Market Order Dropdown")
    public Element marketOrderType;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Limit order']", name = "Limit Order Dropdown")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Limit Order']", name = "Limit Order Dropdown")
    public Element limitOrderType;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Conditional Market Order (SLM)']", name = "Conditional Market Order (SLM) Dropdown")
    public Element condtionalMarketOrderType;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Conditional limit order (SL)']", name = "Conditional limit order (SL)")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Conditional limit order (SL)']", name = "Conditional limit order (SL)")
    public Element conditionalLimitOrder;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Trigger price']/following-sibling::android.widget.EditText", name = "Trigger Price Field")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Trigger Price']/following-sibling::XCUIElementTypeTextField[1]", name = "Trigger Price Field")
    public Element triggerPriceField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Limit price']/following-sibling::android.widget.EditText", name = "Limit Price Field")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Limit price']/following-sibling::XCUIElementTypeTextField[1]", name = "Limit Price Field")
    public Element limitPriceField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Open Your Free Demat & Trading Account'] | //android.widget.TextView[contains(@text,'Resume Opening')]", name = "OnboardingPage Screen Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Open Your Free Demat & Trading Account']", name = "OnboardingPage Screen Text")
    public Element onboardingScreenText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='Switch Exchange']/parent::android.view.View/following-sibling::android.widget.TextView", name = "Stock Price")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name='sort_updown_neutral']/parent::XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText[1]", name = "Stock Price")
    public Element stockPrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='NEXT']", name = "Next Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='NEXT']", name = "Next Button")
    public Element nextButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"back\"]", name = "Back Button")
    public Element backButton;


    public void clickAdvancedDropdown() {
        advancedOptionDropdown.setElementSync(true);
        advancedOptionDropdown.click();
    }

    public void clickConditionalLimitOrder() {
        conditionalLimitOrder.setElementSync(true);
        conditionalLimitOrder.click();
        Assert.assertEquals(orderType.getAttribute("text"), "Conditional Limit");
    }

    public void clickCondtionalMarketOrderType() {
        condtionalMarketOrderType.setElementSync(true);
        condtionalMarketOrderType.click();
        Assert.assertEquals(orderType.getAttribute("text"), "Conditional Market");
    }

    public void clickOrderTypeDropdown() {
        orderTypeDropdown.setElementSync(true);
        orderTypeDropdown.click();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.loadElement();
        placeOrderButton.setElementSync(true);
        placeOrderButton.click();
    }


    public OrderPage verifySuccessfulOrder() {
        Assert.assertEquals(placeOrderMessage.isDisplayed(), true);
        return new OrderPage();
    }

    public void clickChartToggle() {
        chartsToggle.setElementSync(true);
        chartsToggle.click();
    }

    public void clickDepthToggle() {
        depthToggle.setElementSync(true);
        depthToggle.click();
    }

    public void enterQuantity() {
        String qty = RandomStringUtils.random(2, false, true);
        qtyField.setElementSync(true);
        qtyField.click();
        qtyField.clear();
        qtyField.sendKeys(qty);
        utils.waitForElementToDisplay(chartsToggle);
        utils.waitForElementToDisplay(depthToggle);
        clickNextButton();
    }

    public void clickValidityDropdown() {
        validityDropdown.setElementSync(true);
        validityDropdown.click();
    }

    public void selectIOCValidity() {
        iocValidity.click();
        utils.waitForElementToDisplay(advancedOptionDropdown);
        Assert.assertEquals(validity.getAttribute("text"), "IOC - Immediate or Cancel");
    }

    public void clickIntraday() {
        intradayButton.setElementSync(true);
        intradayButton.click();
    }

    public void enterTriggerPrice() {
        triggerPriceField.click();
        triggerPriceField.clear();
        triggerPriceField.sendKeys(calculateTriggerPrice());
        clickNextButton();
    }

    public void clickNextButton() {
        utils.loadUntilElementFound(nextButton);
        nextButton.setElementSync(true);
        nextButton.click();
    }

    public void enterLimitPrice() {
        limitPriceField.click();
        limitPriceField.clear();
        limitPriceField.sendKeys(calculateLimitPrice());
        nextButton.click();
    }

    public String calculateTriggerPrice() {
        int ltp = (int) (Double.parseDouble(stockPrice.getText().split("\\(")[0].trim()) * 1.02);
        return String.valueOf(ltp);
    }

    public String calculateLimitPrice() {
        int ltp = (int) (Integer.parseInt(calculateTriggerPrice()) * 1.02);
        return String.valueOf(ltp);
    }
}
