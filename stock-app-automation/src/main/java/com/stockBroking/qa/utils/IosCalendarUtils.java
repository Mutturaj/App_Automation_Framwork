package com.stockBroking.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class IosCalendarUtils {


    private final WebDriverWait wait;

    public IosCalendarUtils(AppiumDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private static final By pickerScreen = MobileBy.className("XCUIElementTypePicker");
    private static final By pickers = MobileBy.className("XCUIElementTypePickerWheel");

    public void selectDate(String dob) {
        String[] splitDate = dob.split("\\s+");
        wait.until(ExpectedConditions.presenceOfElementLocated(pickerScreen)).click();
        List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickers));

        String date = splitDate[0].replaceAll("^\"|\"$", "");
        pickerEls.get(0).sendKeys(date);

        String month = splitDate[1].replaceAll("^\"|\"$", "");
        pickerEls.get(1).sendKeys(month);

        String year = splitDate[2].replaceAll("^\"|\"$", "");
        pickerEls.get(2).sendKeys(year);

        if(pickerEls.get(0).getText().equals(date) && pickerEls.get(1).getText().equals(month) && pickerEls.get(2).getText().equals(year)){
            System.out.println("Date selected in calender");
        }
    }
}
