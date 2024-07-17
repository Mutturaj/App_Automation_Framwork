package com.stockBroking.qa.pages.login;

import com.google.common.collect.ImmutableList;
import com.stockBroking.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import listner.ThreadCreator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import java.time.Duration;

import static listner.ThreadCreator.getLocalDriver;


public class LoginPage extends BasePage {

    public LoginPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }

    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"Continue with PhonePe\"]", name = "Continue with Phonepe")
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Continue with PhonePe']", name = "Continue with PhonePe")
    public Element continueWithPhonePe;
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Use your PhonePe Account to proceed with Share.Market\"]", name = "use your phonepe acc text1")
    public Elements useYourPhonePeAccText1;
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='pin_input']", name = "enter passcode1")
    public Elements pinField1;


    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "com.google.android.gms:id/cancel", name = "Mobile number pop-up1")
    public Elements continueWithMobileNumberPopUp1;
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"Continue with PhonePe\"]", name = "Home Screen App Icon")
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc='icon']", name = "Home screen App icon")
    public Element appIcon;

    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "getStartedLogo", name = "Share Market App Logo")
    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Sharemarket app logo", name = "Share market App Logo")
    public Element appLogo;

    @PPiOSFindBy(by = MobileByStrategy.CLASSNAME, locator = "XCUIElementTypeTextField", name = "enter mobile number")
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"mobile_input\"]/android.widget.EditText", name = "enter mobile number")
    public Element enterMobileNumber;


    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Use your PhonePe Account to proceed with Share.Market", name = "use your phonePe acc text")
    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Use your PhonePe Account to proceed with Share.Market\"]", name = "use your phonepe acc text")
    public Element useYourPhonePeAccText;


    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Enter Mobile Number']", name = "Enter Mobile Number Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Enter Mobile Number\"]", name = "Enter Mobile Number Text")
    public Element enterMobileNumberText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='PROCEED']", name = "login proceed button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"PROCEED\"]", name = "login proceed button")
    public Element loginProceed;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Verify Your Mobile Number']", name = "Otp screen")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Verify Your Number", name = "Otp screen")
    public Element enterOtpScreen;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Resend OTP", name = "Resend OTP")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Resend OTP", name = "Resend OTP")
    public Element reSendOtp;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@index='5']", name = "Auto reading OTP")
    public Element autoReadingOtp;

    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name, 'Resend OTP')]", name = "Resend OTP with timer")
    public Element resendOtpWithTimer;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Discover']", name = "Discover page header")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Discover']", name = "Discover page header")
    public Element discoverPageHeader;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Enter 4 digit Passcode']", name = "Enter 4 digit Passcode")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Enter Passcode", name = "Enter 4 digit Passcode")
    public Element enterPasscode;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "com.google.android.gms:id/cancel", name = "Mobile number pop-up")
    public Element continueWithMobileNumberPopUp;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "com.android.permissioncontroller:id/permission_allow_button", name = "allow button")
    public Element notificationAllowButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[contains(@text,'GET STARTED')]", name = "Get started")
    public Element getStartedButton;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "com.google.android.gms:id/progress_indicator", name = "emulator progress bar")
    public Element loadingEmulator;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "mobile_input", name = "enter mobile textfield")
    public Element mobileField;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "proceed_button", name = "proceed button")
    public Element proceedButton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "verify_button", name = "verify otp button")
    public Element verifyOtpButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='pin_input']", name = "enter passcode")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Enter Passcode\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther", name = "enter passcode")
    public Element pinField;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='RETRY']", name = "Retry button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "RETRY", name = "Retry button")
    public Element retryButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='CHANGE MOBILE NUMBER']", name = "change mobile number button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "CHANGE MOBILE NUMBER", name = "Change mobile number button")
    public Element changeMobileNumber;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Enable Login via Biometric']", name = "Enable Login via Biometric")
    public Element enableBiometricScreen;

    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]", name = "OTP")
    public Element otpTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@index='0']", name = "otp First TextBox")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeStaticText", name = "otp First TextBox")
    public Element otpFirstTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@index='1']", name = "second First TextBox")
    public Element otpSecondTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@index='2']", name = "third First TextBox")
    public Element otpThirdTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@index='3']", name = "forth First TextBox")
    public Element otpForthTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@index='4']", name = "fifth First TextBox")
    public Element otpFifthTextBox;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Sorry, wrong OTP']", name = "wrong OTP text")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Sorry, Wrong OTP", name = "wrong OTP text")
    public Element wrongOtpText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc='help']", name = "Help")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "help", name = "Help")
    public Element help;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Help Center']", name = "Help center")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Help Center']", name = "Help center")
    public Element helpCenter;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='NO, I’LL USE PASSCODE']", name = "NO, I’LL USE PASSCODE")
    public Element usePasscode;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Unable to proceed']", name = "unable to processed")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Unable to proceed']", name = "unable to processed")
    public Element unableToProcessed;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "back", name = "back on wrong Otp screen")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "CLOSE", name = "back on wrong Otp screen")
    public Element backOnWrongOtp;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Discover", name = "Discover Tab")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Discover", name = "Discover Tab")
    public Element discoverTab;

    public void clickOnXIcon() {
        backOnWrongOtp.click();
    }

    public boolean checkContinueWithPhonePeText() {
        continueWithPhonePe.loadElement();
        return continueWithPhonePe.isDisplayed();
    }

    public boolean checkUseYourPhonepeAcc() {
        useYourPhonePeAccText.loadElement();
        return useYourPhonePeAccText.isDisplayed();
    }

    public boolean checkHelpCenter() {
        return helpCenter.isDisplayed();
    }

    public void clickOnUsePasscode() {
        usePasscode.setElementSync(true);
        usePasscode.click();
    }

    public boolean checkForEnableBiometricPage() {
        return usePasscode.isDisplayed();
    }

    public void clickOnHelp() throws InterruptedException {
        try {
            help.setElementSync(true);
            help.click();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            help.setElementSync(true);
            help.click();
        }
    }

    public void enterOtp(String otps) throws InterruptedException {
        char[] otpChar = otps.toCharArray();
        otpTextBox.sendKeys(String.valueOf(otpChar[0]));
        Thread.sleep(1000);
        otpTextBox.sendKeys(String.valueOf(otpChar[1]));
        Thread.sleep(1000);
        otpTextBox.sendKeys(String.valueOf(otpChar[2]));
        Thread.sleep(1000);
        otpTextBox.sendKeys(String.valueOf(otpChar[3]));
        Thread.sleep(1000);
        otpTextBox.sendKeys(String.valueOf(otpChar[4]));
    }

    public boolean wrongOtpTextVerification() throws InterruptedException {
        try {
            return wrongOtpText.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            return wrongOtpText.isDisplayed();
        }

    }

    public boolean checkBiometricScreen() throws InterruptedException {
        try {
            return enableBiometricScreen.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            return enableBiometricScreen.isDisplayed();
        }
    }

    public void clickOnContinueWithPhonePe() throws InterruptedException {
        try {
            continueWithPhonePe.setElementSync(true);
            continueWithPhonePe.click();
        } catch (NoSuchElementException e) {
            continueWithPhonePe.setElementSync(true);
            continueWithPhonePe.click();
        }
    }

    public boolean checkAppScreenAppIcon() throws InterruptedException {
        try {
            return appLogo.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            return appLogo.isDisplayed();
        }
    }

    public boolean checkEnterMobileNumberText() throws InterruptedException {
        try {
            return enterMobileNumberText.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            return enterMobileNumberText.isDisplayed();
        }
    }

    public boolean checkAutoReadingText() throws InterruptedException {
        try {
            return autoReadingOtp.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(100);
            return autoReadingOtp.isDisplayed();
        }
    }

    public void resendOtp() throws InterruptedException {
        try {
            reSendOtp.setElementSync(true);
            reSendOtp.click();
        } catch (NoSuchElementException e) {
            reSendOtp.setElementSync(true);
            reSendOtp.click();
        }
    }


    public void enterCustomerNumber(String mobileNumber) {
        try {
            enterMobileNumber.click();
            enterMobileNumber.clear();
            enterMobileNumber.sendKeys(mobileNumber);
        } catch (StaleElementReferenceException e) {
            enterMobileNumber.click();
            enterMobileNumber.clear();
            enterMobileNumber.sendKeys(mobileNumber);
        }
    }

    public void clickOnLoginProceedButton() throws InterruptedException {
        try {
            loginProceed.click();
        } catch (NoSuchElementException e) {
            loginProceed.click();
        }
    }

    public boolean discoverHeaderIsDisplayed() {
        try {
            return discoverPageHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return discoverPageHeader.isDisplayed();
        }
    }

    public boolean otpScreenIsDisplayed() throws InterruptedException {
        try {
            enterOtpScreen.loadElement();
            return enterOtpScreen.isDisplayed();
        } catch (NoSuchElementException e) {
            enterOtpScreen.loadElement();
            return enterOtpScreen.isDisplayed();
        }
    }

    public void dismissMobileNumberPopUp() {
        continueWithMobileNumberPopUp.loadElement();
        continueWithMobileNumberPopUp.setElementSync(true);
        continueWithMobileNumberPopUp.click();

    }

    public void clickAllowButton() {
        if (notificationAllowButton.isDisplayed()) {
            notificationAllowButton.setElementSync(true);
            notificationAllowButton.click();
        }
    }

    public void clickGetStartedButton() {
        if (getStartedButton.isDisplayed()) {
            getStartedButton.setElementSync(true);
            getStartedButton.click();
        }
    }

    public boolean checkPasscodeText(TestUtils testUtils) throws InterruptedException {
        try {
            testUtils.waitForElementToDisplay(enterPasscode);
            enterPasscode.loadElement();
            return enterPasscode.isDisplayed();
        } catch (TimeoutException e) {
            enterPasscode.loadElement();
            return enterPasscode.isDisplayed();
        }
    }

    public void enterMobileNumber(String mobile) {
        if (loadingEmulator.isDisplayed()) {
            Point point = new Point(450, 725);
            tapAtPoint(point);

        }
        try {
            mobileField.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!mobileField.getText().isEmpty()) {
            Actions action = new Actions(getLocalDriver());
            action.moveToElement(mobileField).doubleClick().click().keyDown("67").build().perform();
        }
        Actions action = new Actions(getLocalDriver());
        action.sendKeys(mobile);
        action.perform();
    }


    public void tapAtPoint(Point point) {
        AppiumDriver d = getLocalDriver();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 0);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.x, point.y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(input, Duration.ofMillis(200)));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        d.perform(ImmutableList.of(tap));
    }


    public void enterPin(String pin) {
        pinField.loadElement();
        pinField.click();
        Actions action = new Actions(getLocalDriver());
        action.sendKeys(pin);
        action.perform();
    }

    public void clickOnRetry() throws InterruptedException {
        try {
            retryButton.setElementSync(true);
            retryButton.click();
        } catch (NoSuchElementException e) {
            retryButton.setElementSync(true);
            retryButton.click();
        }
    }

    public void clickOnChangePhoneNumber() throws InterruptedException {
        try {
            changeMobileNumber.setElementSync(true);
            changeMobileNumber.click();
        } catch (NoSuchElementException e) {
            changeMobileNumber.setElementSync(true);
            changeMobileNumber.click();
        }

    }


}
