package com.stockBroking.qa.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pagefactory.elements.Element;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static listner.ThreadCreator.getLocalDriver;

public class CalendarUtils {


    public static int getMonthNumber(String monthName) throws ParseException {
        Date date = new SimpleDateFormat("MMMM").parse(monthName);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public String getMonthNameInThreeChars(String date) {
        return date.substring(5, 8);
    }

    public void setAndroidDatePicker(String date, Element years) throws ParseException {
        //int thisYear = Integer.valueOf(getLocalDriver().findElement(By.id("android:id/date_picker_header_year")).getAttribute("name"));
        String today = getLocalDriver().findElement(By.id("android:id/date_picker_header_date")).getAttribute("name");
        int thisMonth = getMonthNumber(getMonthNameInThreeChars(today));
        // Split the given date into date, month and year
        String[] splitDate = date.split("\\s+");

        int givenDay = Integer.parseInt(splitDate[0]);
        int givenMonth = getMonthNumber(splitDate[1]);
        int givenYear = Integer.parseInt(splitDate[2]);

        int forwardTaps = 0;
        int backwardTaps = 0;

        selectYear(Integer.toString(givenYear), years);
        if (givenMonth > thisMonth) {
            forwardTaps = givenMonth - thisMonth;
        } else if (givenMonth < thisMonth){
            backwardTaps = thisMonth - givenMonth;
        }

        for (int i = 1; i <= forwardTaps; i++) {
            getLocalDriver().findElement(By.id("android:id/next")).click();
        }

        for (int i = 1; i <= backwardTaps; i++) {
            getLocalDriver().findElement(By.id("android:id/prev")).click();
        }

        String xpath = "//android.view.View[@text='day']";
        getLocalDriver().findElement(By.xpath(xpath.replace("day", String.valueOf(givenDay)))).click();
        //Tap on OK button of the date picker
        getLocalDriver().findElement(By.id("android:id/button1")).click();

    }

    public void selectYear(String year, Element years) {
        getLocalDriver().findElement(By.id("android:id/date_picker_header_year")).click();
        scrollTillElement(years, year);
        getLocalDriver().findElement(By.xpath("//android.widget.TextView[@text='" + year + "']")).click();
    }


    public Boolean scrollTillElement(Element element, String year) {
        Boolean flag = false;
        element.setMobileRegex(new String[]{year});
        for (int i = 0; i < 10; i++) {
            element.loadElement();
            if (element.isDisplayed()) {
                return true;
            } else {
                Dimension dimension = getLocalDriver().manage().window().getSize();
                hardSwipe(dimension.getWidth() / 2, dimension.getHeight() / 2, dimension.getWidth() / 2, (int) (dimension.getHeight() * 0.8));
            }
        }
        return flag;
    }

    void hardSwipe(int startX, int startY, int endX, int endY, Duration moveDuration, Duration initialWait) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0L), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, initialWait));
        sequence.addAction(finger.createPointerMove(moveDuration, PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        getLocalDriver().perform(Collections.singletonList(sequence));
    }

    void hardSwipe(int startX, int startY, int endX, int endY) {
        this.hardSwipe(startX, startY, endX, endY, Duration.ofSeconds(5L), Duration.ofSeconds(2L));
    }
}
