package com.stockBroking.qa.pages.profile;

import com.stockBroking.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebDriver;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import java.util.HashMap;
import java.util.Map;

import static listner.ThreadCreator.getLocalDriver;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Enter PAN']/following-sibling::android.widget.EditText", name = "enter pan")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Enter PAN']/following-sibling::XCUIElementTypeTextField", name = "enter pan")
    public Element enterPan;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Date of Birth']/following-sibling::android.view.View", name = "DOB calender")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "DD/MM/YYYY", name = "DOB calender")
    public Element dobCalender;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='PROCEED']", name = "Proceed button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "PROCEED", name = "PROCEED button")
    public Element proceedButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='%s']", name = "year")
    public Element year;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='You've entered the wrong PAN. Please try again with the correct PAN details']", name = "Invalid PAN toast msg")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "You've entered the wrong PAN. Please try again with the correct PAN details", name = "Invalid PAN toast msg")
    public Element invalidPanToastMsg;

    public boolean isInvalidPanToastDisplayed(TestUtils testUtils){
        testUtils.waitForElementToDisplay(invalidPanToastMsg);
        return invalidPanToastMsg.isDisplayed();
    }

    public void clickOnProceed(){
        proceedButton.setElementSync(true);
        proceedButton.click();
    }


    public void clickOnCalender(){
        dobCalender.setElementSync(true);
        dobCalender.click();
    }

    public void enterPan(String pan){
        enterPan.click();
        enterPan.clear();
        enterPan.sendKeys(pan);
    }

}
