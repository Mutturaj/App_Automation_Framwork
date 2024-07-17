package com.stockBroking.qa.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import listner.ThreadCreator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static listner.ThreadCreator.getLocalDriver;
import static listner.ThreadCreator.getWebDriverWait;

public class TestUtils extends PerformAction {


    public void waitForElementToDisplay(Element element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getLocalDriver())
                .withTimeout(Duration.ofSeconds(45L))
                .pollingEvery(Duration.ofSeconds(1L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element.getBy()));
    }

    public Boolean isClickable(Element element) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getLocalDriver())
                    .withTimeout(Duration.ofSeconds(10L))
                    .pollingEvery(Duration.ofSeconds(2L))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element.getBy()));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void waitAndVerifyAnyOneOfElement(Element element1, Element element2) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getLocalDriver())
                .withTimeout(Duration.ofSeconds(45L))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(element1.getBy()),
                ExpectedConditions.visibilityOfElementLocated(element2.getBy())));
    }

    public void waitForElementToBeInvisible(Element element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getLocalDriver())
                .withTimeout(Duration.ofSeconds(45L))
                .pollingEvery(Duration.ofSeconds(2L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element.getBy()));
    }

    public Boolean isPresent(Element element) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getLocalDriver())
                    .withTimeout(Duration.ofSeconds(10L))
                    .pollingEvery(Duration.ofSeconds(1L))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(element.getBy()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterKeyCodeText(AppiumDriver driver, String KeyCodeText) {
        List inputText = Arrays.asList("text", KeyCodeText);
        Map inputCommand = ImmutableMap.of("command", "input", "args", inputText);
        driver.executeScript("mobile: shell", inputCommand);
    }

    public void deviceBackKey() {
        ((AndroidDriver) getLocalDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void hideKeyboard() {
        if (((AndroidDriver) getLocalDriver()).isKeyboardShown())
            ((AndroidDriver) getLocalDriver()).hideKeyboard();
    }

    public <T> Class<T> waitForPageToLoad(Class<T> returnClassType, Element element) {
        getWebDriverWait().until(
                ExpectedConditions.visibilityOfElementLocated(element.getBy()));
        return returnClassType;
    }

    public void scrollVerticallyTillElement(Element element) {
        for (int i = 0; i < 5; i++) {
            element.loadElement();
            if (!element.isDisplayed()) {
                Dimension dimension = getLocalDriver().manage().window().getSize();
                this.hardSwipe(dimension.getWidth() / 2, (int) (dimension.getHeight() * 0.7), dimension.getWidth() / 2, 0);
            }
        }
    }

    public Boolean slowScrollVerticallyTillElement(Element element) {
        Boolean flag = false;
        for (int i = 0; i < 5; i++) {
            element.loadElement();
            if (element.isDisplayed()) {
                return true;
            } else {
                Dimension dimension = getLocalDriver().manage().window().getSize();
                this.hardSwipe(dimension.getWidth() / 2, (int) (dimension.getHeight() * 0.3), dimension.getWidth() / 2, 0);
            }
        }
        return flag;
    }

    public Boolean scrollHorizontallyTillElement(Element referenceElement, Element targetElement) {
        Boolean flag = false;
        referenceElement.loadElement();
        for (int i = 0; i < 5; i++) {
            targetElement.loadElement();
            if (!targetElement.isDisplayed()) {
                Dimension dimension = getLocalDriver().manage().window().getSize();
                int startY = referenceElement.getLocation().getY();
                this.horizontalSwipe(dimension.getWidth() / 2, startY, 0);
            }
        }
        return flag;
    }

    private void hardSwipe(int startX, int startY, int endX, int endY, Duration moveDuration, Duration initialWait) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0L), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
//        sequence.addAction(new Pause(finger, initialWait));
        sequence.addAction(finger.createPointerMove(moveDuration, PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        getLocalDriver().perform(Collections.singletonList(sequence));
    }

    private void horizontalSwipe(int startX, int centerY, int endX) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), (int) endX, centerY));
        swipe.addAction(finger.createPointerUp(0));
        ThreadCreator.getLocalDriver().perform(Arrays.asList(swipe));
    }

    private void hardSwipe(int startX, int startY, int endX, int endY) {
        this.hardSwipe(startX, startY, endX, endY, Duration.ofSeconds(5L), Duration.ofSeconds(2L));
    }

    public void loadUntilElementFound(Element element) {
        int count = 0;
        do {
            element.loadElement();
        }
        while (!element.isDisplayed() && count++ < 10);
    }

    public void loadUntilElementFound(Elements elements) {
        int count = 0;
        do {
            elements.loadElements();
        }
        while (elements.getElements().size() == 0 && count++ < 10);
    }

    public boolean isNumeric(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInteger(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean dateValidator(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm a");
        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (java.text.ParseException e) {
            return false;
        }
    }


    public long measurePageLoadTime() {
        long time = System.currentTimeMillis();
        JavascriptExecutor jsExecutor = getLocalDriver();
        String pageLoadScript = "return (document.readyState == 'complete' && jQuery.active == 0);";
        jsExecutor.executeScript(pageLoadScript);
        return time;
    }

    public void performSingleTap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getLocalDriver().perform(Collections.singletonList(tap));
    }

    public void performSingleTap(Element element) {
        Point sourceLocation = element.getLocation();
        Dimension sourceSize = element.getSize();
        int centerX = sourceLocation.getX() + sourceSize.getWidth() / 2;
        int centerY = sourceLocation.getY() + sourceSize.getHeight() / 2;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getLocalDriver().perform(Collections.singletonList(tap));
    }


}
