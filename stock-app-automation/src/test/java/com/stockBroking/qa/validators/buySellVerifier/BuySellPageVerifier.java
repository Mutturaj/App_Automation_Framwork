package com.stockBroking.qa.validators.buySellVerifier;

import com.stockBroking.qa.pages.orderFlow.OrderPage;
import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuySellPageVerifier {

    public void defaultBuyPageVerifier(OrderPage orderPage, TestUtils utils) {
        utils.waitForElementToDisplay(orderPage.buyStockText);
        Assert.assertTrue(orderPage.buyStockText.isDisplayed());
        Assert.assertTrue(orderPage.productTypeText.isDisplayed());
        Assert.assertTrue(orderPage.orderTypeText.isDisplayed());
        Assert.assertTrue(orderPage.deliveryButton.isDisplayed());
        Assert.assertTrue(orderPage.intradayButton.isDisplayed());
        Assert.assertEquals(orderPage.orderType.getText(), "Market");
        Assert.assertEquals(orderPage.qtyField.getText(), "");
        Assert.assertTrue(orderPage.advancedOptionDropdown.isDisplayed());
        orderPage.clickAdvancedDropdown();
        utils.waitForElementToDisplay(orderPage.validityDropdown);
        Assert.assertTrue(orderPage.validityDropdown.isDisplayed());
        Assert.assertEquals(orderPage.validity.getText(), "Day");
        Assert.assertTrue(orderPage.disclosedQtyDropdown.isDisplayed());
        Assert.assertEquals(orderPage.disclosedQty.getText(), "0%");
    }

    public void switchExchangeVerifier(OrderPage orderPage) {
        Assert.assertTrue(orderPage.nseSwitch.isDisplayed());
        orderPage.switchExchange.click();
        Assert.assertTrue(orderPage.bseSwitch.isDisplayed());
        orderPage.switchExchange.click();
    }

    public void placeOrderErrorTextVerifier(OrderPage orderPage) {
        orderPage.clickPlaceOrderButton();
        Assert.assertTrue(orderPage.qtyErrorText.isDisplayed());
    }

    public void placeConditionalOrderErrorTextVerifier(OrderPage orderPage, TestUtils utils) {
        placeOrderErrorTextVerifier(orderPage);
        Assert.assertTrue(utils.isNumeric(orderPage.triggerPriceField.getText()));
    }

    public void placeConditionalLimitOrderErrorTextVerifier(OrderPage orderPage, TestUtils utils) {
        placeConditionalOrderErrorTextVerifier(orderPage, utils);
        Assert.assertTrue(utils.isNumeric(orderPage.triggerPriceField.getText()));
    }


    public void depthToggleVerifier(OrderPage orderPage) {
        orderPage.clickDepthToggle();
        Assert.assertTrue(orderPage.totalColumn.isDisplayed());
        orderPage.clickDepthToggle();
        Assert.assertFalse(orderPage.totalColumn.isDisplayed());
    }

    public void defaultValidityDropdownVerifier(OrderPage orderPage, TestUtils utils) {
        utils.waitForElementToDisplay(orderPage.validityDropdownHeader);
        Assert.assertTrue(orderPage.validityDropdownHeader.isDisplayed());
        Assert.assertTrue(orderPage.dayValidity.isDisplayed());
        Assert.assertTrue(orderPage.iocValidity.isDisplayed());
        orderPage.validitySelected.loadElement();
        Assert.assertEquals(orderPage.validitySelected.getText(), "Day");
    }

    public void defaultOrderTypeDropdownVerifier(OrderPage orderPage, TestUtils utils) {
        utils.waitForElementToDisplay(orderPage.orderTypeDropdownHeader);
        Assert.assertTrue(orderPage.orderTypeDropdownHeader.isDisplayed());
        Assert.assertTrue(orderPage.marketOrderType.isDisplayed());
        Assert.assertTrue(orderPage.limitOrderType.isDisplayed());
        Assert.assertTrue(orderPage.condtionalMarketOrderType.isDisplayed());
        Assert.assertTrue(orderPage.conditionalLimitOrder.isDisplayed());
        orderPage.validitySelected.loadElement();
        Assert.assertEquals(orderPage.validitySelected.getText(), "Market order");
    }
}
