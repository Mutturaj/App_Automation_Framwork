package com.stockBroking.qa.helpers;

import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;
import utilities.EnvironmentVariable;

public class LoginHelpers {

    private final TestUtils testUtils;

    public LoginHelpers() {
        this.testUtils = new TestUtils();
    }

    public void generateOtp(LoginPage loginPage, String mobileNumber) throws InterruptedException {
        testUtils.waitForElementToDisplay(loginPage.useYourPhonePeAccText);
        Assert.assertTrue(loginPage.checkAppScreenAppIcon());
        if (EnvironmentVariable.getAvailableInstance().isIos()) {
            loginPage.clickOnContinueWithPhonePe();
        }
        testUtils.waitForElementToDisplay(loginPage.enterMobileNumber);
        loginPage.enterCustomerNumber(mobileNumber);
        //testUtils.enterKeyCodeText(getLocalDriver(), mobileNumber);
        loginPage.clickOnLoginProceedButton();
    }

    public void login(LoginPage loginPage, String mobileNumber, String pin) throws InterruptedException {

        generateOtp(loginPage, mobileNumber);
        if (loginPage.checkPasscodeText(testUtils)) {
            loginPage.enterPin(pin);
        }
        if(EnvironmentVariable.getAvailableInstance().isAndroid()){
            if (loginPage.checkForEnableBiometricPage()) {
                loginPage.clickOnUsePasscode();
            }
        }
        loginPage.discoverTab.setElementSync(true);
        loginPage.discoverTab.click();
        testUtils.waitForElementToDisplay(loginPage.discoverPageHeader);
        Assert.assertTrue(loginPage.discoverHeaderIsDisplayed());
    }

    public void enterPasscode(LoginPage loginPage, String pin) throws InterruptedException {
        loginPage.enterPin(pin);
        if (loginPage.checkForEnableBiometricPage()) {
            loginPage.clickOnUsePasscode();
        }
    }

}
