package com.stockBroking.qa.appTests.loginTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.dataprovider.LoginDP;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.profile.ForgotPasswordPage;
import com.stockBroking.qa.utils.CalendarUtils;
import com.stockBroking.qa.utils.IosCalendarUtils;
import com.stockBroking.qa.utils.NavigationHelper;
import io.qameta.allure.*;
import jdk.jfr.Description;
import listner.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.utils.TestUtils;
import utilities.EnvironmentVariable;

import java.lang.reflect.Method;
import java.text.ParseException;
import static listner.ThreadCreator.getLocalDriver;

@Listeners(TestListener.class)
@Feature("Sign in Test")
public class LoginTest extends ShareMarketBaseTest {


    private final TestUtils testUtils;
    private final LoginHelpers loginHelpers;
    private final CalendarUtils dateUtils;

    LoginTest() {
        this.testUtils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.dateUtils = new CalendarUtils();

    }

    @Override
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        if (env.isAndroid())
            this.executor.beforeMethodCompulsory(method, "CUSTOM_ANDROID_CAPS");
        else
            this.executor.beforeMethodCompulsory(method, "CUSTOM_IOS_CAPS");

        this.executor.beforeMethodOptional(method);
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the OTP screen")
    @Story("Validate the OTP screen")
    @Test(description = "Verify the user is redirected to OTP screen on selecting Proceed option", dataProvider = "testOtpScreen", dataProviderClass = LoginDP.class)
    void testOtpScreen(String mobileNumber) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        Assert.assertTrue(loginPage.otpScreenIsDisplayed());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the OTP screen")
    @Story("Validate the OTP screen")
    @Test(description = "Verify Resend code option is provided in OTP screen", dataProvider = "resendOtp", dataProviderClass = LoginDP.class)
    void resendOtp(String mobileNumber) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.reSendOtp);
        loginPage.resendOtp();
        if(EnvironmentVariable.getAvailableInstance().isAndroid()){
            testUtils.waitForElementToDisplay(loginPage.autoReadingOtp);
            Assert.assertTrue(loginPage.checkAutoReadingText());
        }else {
            testUtils.waitForElementToDisplay(loginPage.resendOtpWithTimer);
            Assert.assertTrue(loginPage.resendOtpWithTimer.isDisplayed());
        }
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Sing in with PhonePe")
    @Story("Sign in for a user with PhonePe")
    @Test(description = "Sing in with PhonePe", dataProvider = "loginWithPhonePe", dataProviderClass = LoginDP.class)
    void loginWithPhonePe(String mobileNumber, String pin) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.login(loginPage,mobileNumber, pin);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Sing in with wrong OTP")
    @Story("Test Description: Sing in with wrong OTP")
    @Test(description = "Sing in with wrong OTP", dataProvider = "wrongOtpTest", dataProviderClass = LoginDP.class)
    void wrongOtpTest(String mobileNumber, String otp) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        if(EnvironmentVariable.getInstance().isIos()){
            loginPage.enterOtp(otp);
        }else{
            testUtils.enterKeyCodeText(getLocalDriver(), otp);
        }
        testUtils.waitForElementToDisplay(loginPage.wrongOtpText);
        Assert.assertTrue(loginPage.wrongOtpTextVerification());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Retry after wrong OTP")
    @Story("Test Description: Retry after wrong OTP")
    @Test(description = "Retry after wrong OTP", dataProvider = "wrongOtpTest", dataProviderClass = LoginDP.class)
    void otpRetryTest(String mobileNumber, String otp) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        if(EnvironmentVariable.getInstance().isIos()){
            loginPage.enterOtp(otp);
        }else{
            testUtils.enterKeyCodeText(getLocalDriver(), otp);
        }
        if (loginPage.wrongOtpTextVerification()) {
            testUtils.waitForElementToDisplay(loginPage.wrongOtpText);
            Assert.assertTrue(loginPage.wrongOtpTextVerification());
        }
        loginPage.clickOnRetry();
        Assert.assertTrue(loginPage.otpScreenIsDisplayed());
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: change mobile number after wrong OTP")
    @Story("Test Description: change mobile number after wrong OTP")
    @Test(description = "change mobile number after wrong OTP", dataProvider = "wrongOtpTest", dataProviderClass = LoginDP.class)
    void changeMobileNumberTest(String mobileNumber, String otp) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        if (EnvironmentVariable.getInstance().isIos()) {
            loginPage.enterOtp(otp);
        } else {
            testUtils.enterKeyCodeText(getLocalDriver(), otp);
        }
        testUtils.waitAndVerifyAnyOneOfElement(loginPage.wrongOtpText, loginPage.unableToProcessed);
        if (loginPage.wrongOtpText.isDisplayed()) {
            Assert.assertTrue(loginPage.wrongOtpText.isDisplayed());
        } else if (loginPage.unableToProcessed.isDisplayed()) {
            Assert.assertTrue(loginPage.unableToProcessed.isDisplayed());
        }
        Assert.assertTrue(loginPage.wrongOtpTextVerification());
        loginPage.clickOnChangePhoneNumber();
        if (EnvironmentVariable.getInstance().isAndroid()) {
            testUtils.waitForElementToDisplay(loginPage.continueWithMobileNumberPopUp);
            loginPage.dismissMobileNumberPopUp();
        }
        testUtils.waitForElementToDisplay(loginPage.enterMobileNumber);
        Assert.assertTrue(loginPage.checkEnterMobileNumberText());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: change mobile number after wrong OTP")
    @Story("Test Description: change mobile number after wrong OTP")
    @Test(description = "change mobile number after wrong OTP", dataProvider = "wrongOtpTest", dataProviderClass = LoginDP.class)
    void loginHelpTest(String mobileNumber, String otp) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        if (EnvironmentVariable.getInstance().isIos()) {
            loginPage.enterOtp(otp);
        } else {
            testUtils.enterKeyCodeText(getLocalDriver(), otp);
        }
        testUtils.waitForElementToDisplay(loginPage.wrongOtpText);
        Assert.assertTrue(loginPage.wrongOtpTextVerification());
        loginPage.clickOnHelp();
        testUtils.waitForElementToDisplay(loginPage.helpCenter);
        Assert.assertTrue(loginPage.checkHelpCenter());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: If the user click on  X icon in the Sorry wrong OTP page")
    @Story("Test Description: If the user click on  X icon in the Sorry wrong OTP page")
    @Test(description = "If the user click on  X icon in the Sorry wrong OTP page", dataProvider = "closeOtpScreen", dataProviderClass = LoginDP.class)
    void closeOtpScreenTest(String mobileNumber, String pin) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        testUtils.waitForElementToDisplay(loginPage.enterOtpScreen);
        if (EnvironmentVariable.getInstance().isIos()) {
            loginPage.enterOtp(pin);
        } else {
            testUtils.enterKeyCodeText(getLocalDriver(), pin);
        }
        testUtils.waitForElementToDisplay(loginPage.wrongOtpText);
        Assert.assertTrue(loginPage.wrongOtpTextVerification());
        loginPage.clickOnXIcon();
        Assert.assertTrue(loginPage.checkUseYourPhonepeAcc());
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify if user can reset passcode after Login & Also validate teh error messages")
    @Story("Test Description: Verify if user can reset passcode after Login & Also validate teh error messages")
    @Test(description = "Verify if user can reset passcode after Login & Also validate teh error messages", dataProvider = "testResetPassword", dataProviderClass = LoginDP.class)
    void testResetPassword(String mobileNumber, String pin, String pan, String dob, String otp) throws InterruptedException, ParseException {
        LoginPage loginPage = new LoginPage();
        IosCalendarUtils iosCalendarUtils = new IosCalendarUtils(getLocalDriver());
        loginHelpers.login(loginPage, mobileNumber, pin);
        ForgotPasswordPage forgotPasswordPage = new NavigationHelper()
                .goToProfile()
                .clickOnManagePhonePeAccounts()
                .clickOnChangePassword();
        forgotPasswordPage.enterPan(pan);
        forgotPasswordPage.clickOnCalender();
        if(EnvironmentVariable.getAvailableInstance().isAndroid()){
            dateUtils.setAndroidDatePicker(dob, forgotPasswordPage.year);
            forgotPasswordPage.clickOnProceed();
        }else {
            iosCalendarUtils.selectDate(dob);
            testUtils.performSingleTap(24, 119);
            forgotPasswordPage.clickOnProceed();
        }
        String actualToastMes = forgotPasswordPage.invalidPanToastMsg.getText();

    }

/*
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify that if a user enters an incorrect PIN more than 3 times, they should be redirected to the 'Account Blocked' page, Additionally, verify the UI elements and functionality on the 'Account Blocked' page")
    @Story("Test Description: Verify that if a user enters an incorrect PIN more than 3 times, they should be redirected to the 'Account Blocked' page, Additionally, verify the UI elements and functionality on the 'Account Blocked' page")
    @Test(description = "Verify that if a user enters an incorrect PIN more than 3 times, 'Account Blocked'", dataProvider = "zaccountBlocked", dataProviderClass = LoginDP.class)
    void zaccountBlocked(String mobileNumber, String pin) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginHelpers.generateOtp(loginPage, mobileNumber);
        if (loginPage.checkPasscodeText(testUtils)) {
            for(int i=0;i<3; i++){
                loginPage.enterPin(pin);
            }
        }
    }
*/

}


