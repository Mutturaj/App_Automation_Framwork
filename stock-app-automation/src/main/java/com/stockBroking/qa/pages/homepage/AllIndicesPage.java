package com.stockBroking.qa.pages.homepage;

import listner.ThreadCreator;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

public class AllIndicesPage extends BasePage {

    public AllIndicesPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"NSE\"]", name = "NSE Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"NSE\"]", name = "NSE Tab")
    public Element nseTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"BSE\"]", name = "BSE Tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"BSE\"]", name = "BSE Tab")
    public Element bseTab;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"All Indices\"]", name = "All Indices Screen Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"All Indices\"]", name = "All Indices Screen Heading")
    public Element allIndicesScreenHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"All Indices\"]/preceding-sibling::android.widget.Button", name = "Back Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"All Indices\"]/preceding-sibling::XCUIElementTypeImage[@name=\"back\"]", name = "Back Button")
    public Element backButton;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Day", name = "1 Day")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Day", name = "1 Day")
    public Element oneDay;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Week", name = "1 Week")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Week", name = "1 Week")
    public Element oneWeek;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Month", name = "1 Month")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Month", name = "1 Month")
    public Element oneMonth;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Year", name = "1 ")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "1 Year", name = "1 ")
    public Element oneYear;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty 50\"]", name = "Nifty 50 Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Nifty 50\"]", name = "Nifty 50 Index")
    public Element nifty50Index;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty Bank\"]", name = "Nifty Bank Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Nifty Bank\"]", name = "Nifty Bank Index")
    public Element niftyBankIndex;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"BSE Sensex\"]", name = "BSE Sensex Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"BSE Sensex\"]", name = "BSE Sensex Index")
    public Element bseSensexIndex;

}
