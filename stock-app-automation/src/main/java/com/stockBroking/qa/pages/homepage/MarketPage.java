package com.stockBroking.qa.pages.homepage;

import com.stockBroking.qa.pages.scripDetails.ScripDetailsOverviewPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import listner.ThreadCreator;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class MarketPage extends BasePage {

    public MarketPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"Home\"]", name = "home page button")
    public Element homePageButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"Watchlist\"])", name = "click on watch list")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Watchlist", name = "watch list")
    public Element watchlistTab;


    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"watchlist_header\"]/preceding-sibling::android.view.View", name = "profile logo button")
    public Element profileLogo;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Your Holdings Value']", name = "Your holding value")
    public Element yourHoldingValue;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Profit/Loss:']/preceding-sibling::android.widget.TextView", name = "profit and loss")
    public Element profitAndLoss;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Stock Movement\"]/preceding-sibling::android.widget.Button", name = "Back Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Stock Movement\"]/preceding-sibling::XCUIElementTypeImage[@name=\"back\"]", name = "Back Button")
    public Element backButtonStockMovementPage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='1 Day']", name = "one day")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='1 Day']", name = "one day")
    public Element oneDay;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='1 Week']", name = "one Week")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='1 Week']", name = "one Week")
    public Element oneWeek;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='1 Month']", name = "one Month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='1 Month']", name = "one Month")
    public Element oneMonth;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='1 Year']", name = "one Year")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='1 Year']", name = "one Year")
    public Element oneYear;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Top Gainers']", name = "Top Gainers")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"Top Gainers\"]", name = "Top Gainers")
    public Element topGainers;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Top Losers']", name = "Top Losers")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='Top Losers']", name = "Top Losers")
    public Element topLosers;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='52W High']", name = "52W High")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='52W High']", name = "52W High")
    public Element xWeekHigh;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='52W Low']", name = "52W Low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='52W Low']", name = "52W Low")
    public Element xWeekLow;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Active By Volume']", name = "Active by volume")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='Active By Volume']", name = "Active by volume")
    public Element activeByVolume;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Top Gainers\"]/following-sibling::android.widget.Button", name = "View All Top Gainers")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All Top Gainers\"]", name = "View All Top Gainers")
    public Element viewAllTopGainers;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Top Losers\"]/following-sibling::android.widget.Button", name = "View All Top Losers")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "XCUIElementTypeStaticText[@name=\"View All Top Losers\"]", name = "View All Top Losers")
    public Element viewAllTopLosers;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All 52W High\"]/following-sibling::android.widget.Button", name = "View All 52 Week High")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All 52W High\"]", name = "View All 52 Week High")
    public Element viewAll52WHigh;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All 52W Low\"]/following-sibling::android.widget.Button", name = "View All 52 Week Low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All 52W Low\"]", name = "View All 52 Week Low")
    public Element viewAll52WLow;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Active By Volume\"]/following-sibling::android.widget.Button", name = "View All Active by Volume")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All Active By Volume\"]", name = "View All Active by Volume")
    public Element viewAllActiveByVolume;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"script logo\"])[1]", name = "First scrip")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"stocks_placeholder\"])[1]", name = "First scrip")
    public Element firstScrip;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"script logo\"]/following-sibling::android.widget.TextView[contains(@text,\"%\")])[1]", name = "First Scrip Per Change")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"stocks_placeholder\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"%\")])[1]", name = "First Scrip Per Change")
    public Element firstScripPerChange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"script logo\"]/following-sibling::android.widget.TextView[contains(@text,\"%\")]", name = "Scrip Per Change")
    public Elements scripPerChangeInStockMovement;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"script logo\"]/following-sibling::android.widget.TextView[not (contains(@text,\"%\"))][contains(@text,\"+\")]", name = "Scrip Positive Points")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name=\"stocks_placeholder\"]/following-sibling::XCUIElementTypeStaticText[not (contains(@name,\"%\"))][contains(@name,\"+\")]", name = "Scrip Positive Points")
    public Elements scripPositiveChange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"script logo\"]/following-sibling::android.widget.TextView[not (contains(@text,\"%\"))][contains(@text,\"-\")]", name = "Scrip Negative Points")
    public Element scripNegativeChange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Company\"]", name = "Company Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Company\"]", name = "Company Column")
    public Element companyColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Today's Chg\"]", name = "Today Change Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Today’s Chg\"]", name = "Today Change Column")
    public Element todayChangeColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"LTP\"]", name = "Ltp Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"LTP\"]", name = "Ltp Column")
    public Element ltpColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume (in Cr)\"]", name = "Volume Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Volume\"]", name = "Volume Column")
    public Element volumeInCrColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Start Your Investment Journey With Us\"]/following-sibling::android.view.View//android.widget.TextView[@text=\"OPEN\"] | //android.widget.TextView[@text=\"Resume Opening Your Demat Account\"]/following-sibling::android.view.View//android.widget.TextView[@text=\"RESUME\"]", name = "Open Demat Banner")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Start Your Investment Journey With Us\"]/following-sibling::XCUIElementTypeButton[@name=\"OPEN\"]", name = "Open Demat Banner")
    public Element openDematBanner;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Indices\"]", name = "Indices Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Indices\"]", name = "Indices Heading")
    public Element indicesHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty 50\"]", name = "Nifty 50 Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]", name = "Nifty 50 Index")
    public Element nifty50Index;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView)[1]", name = "Nifty 50 Ltp")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]/following-sibling::XCUIElementTypeStaticText)[1]", name = "Nifty 50 Ltp")
    public Element niftyLtp;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView[contains(@text,\"% \")]", name = "Nifty 50 % change")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"%)\")])[1]", name = "Nifty 50 % change")
    public Element niftyPerChange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView[contains(@text,\"%\")][not(contains(@text,\"(\"))])[1]", name = "Adv %")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"%\")])[2]", name = "Adv %")
    public Element advPercent;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView[contains(@text,\"%\")][not(contains(@text,\"(\"))])[2]", name = "Dec %")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"%\")])[3]", name = "Dec %")
    public Element decPercent;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView[@text=\"Adv.\"]", name = "Adv Label Nifty 50")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty 50\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"Adv.\")])[1]", name = "Adv Label Nifty 50")
    public Element advLabelNifty50;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty 50\"]/following-sibling::android.widget.TextView[@text=\"Dec.\"]", name = "Dec Label Nifty 50")
    public Element decLabelNifty50;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"BSE Sensex\"]", name = "Bse Sensex Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"BSE Sensex\"]", name = "Bse Sensex Index")
    public Element bseSensexIndex;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Nifty Bank\"]", name = "Nifty Bank Index")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Indices\"]/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[@name=\"Nifty Bank\"]", name = "Nifty Bank Index")
    public Element niftyBankIndex;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Indices\"]/following-sibling::android.view.View[@content-desc=\"View All\"]", name = "View All Indices")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View \nAll Indices\"]", name = "View All Indices")
    public Element viewAllIndices;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Advances & Declines\"]/following-sibling::android.widget.TextView[@text=\"(in Nifty 500)\"]", name = "Advances And Declines Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Advances & Declines\"]/following-sibling::XCUIElementTypeStaticText[@name=\"(in Nifty 500)\"]", name = "Advances And Declines Heading")
    public Element advancesAndDeclinesHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,\"Advances :\")]", name = "Advances Label")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name, \"Advances :\")]", name = "Advances Label")
    public Element advancesLabel;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[contains(@text,\"Declines :\")]", name = "Declines Label")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[contains(@name, \"Declines :\")]", name = "Declines Label")
    public Element declinesLabel;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"circle_info\"]", name = "Advances and Declines Info Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"info\"]", name = "Advances and Declines Info Button")
    public Element advancesAndDeclineInfoButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Advances & Declines\"]/following-sibling::android.widget.TextView[contains(@text,\"Advances and declines refer to the\")]", name = "Advances and Declines Info Popup")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Advances & Declines\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"Advances and declines refer to\")]", name = "Advances and Declines Info Popup")
    public Element advancesAndDeclineInfoPopup;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\">5%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Greater than 5 count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\">5%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Greater than 5 count")
    public Element greaterThan5Count;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"5~2%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Between 5 to 2 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"5~2%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Between 5 to 2 Count")
    public Element between5To2Count;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"2~0%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Between 2 to 0 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"2~0%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Between 2 to 0 Count")
    public Element between2To0Count;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"0%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "0 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"0%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "0 Count")
    public Element zeroCount;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"0~-2%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Between 0 to -2 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"0~-2%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Between 0 to -2 Count")
    public Element between0ToMinus2;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"-2~-5%\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Between -2 to -5 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"-2~-5%\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Between -2 to -5 Count")
    public Element betweenMinus2ToMinus5;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"-5%<\"]/preceding-sibling::android.widget.TextView)[last()]", name = "Greater than -5 Count")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"-5%<\"]/preceding-sibling::XCUIElementTypeStaticText)[last()]", name = "Greater than -5 Count")
    public Element greaterThanMinus5;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Stock Movement\"]", name = "Stock Market Card Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Stock Movement\"]", name = "Stock Market Card Heading")
    public Element stockMarketCardHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Sectoral Performance\"]", name = "Sectoral Performance")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Sectoral Performance\"]", name = "Sectoral Performance")
    public Element sectoralPerformanceHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Sectors\"]", name = "View All Sectors")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All Sectors\"]", name = "View All Sectors")
    public Element viewAllSectors;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Sector\"]", name = "Sector Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Sector\"]", name = "Sector Column")
    public Element sectorColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Change %\"]", name = "change % column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Change %\"]", name = "change % column")
    public Element changePercentColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Adv./Dec.\"]", name = "Adv./Dec. Column")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Adv./Dec.\"]", name = "Adv./Dec. Column")
    public Element advDecColumn;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty Bank\"]/following-sibling::android.widget.TextView)[1]", name = "Nifty Bank Change")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Nifty Bank\"]/following-sibling::XCUIElementTypeStaticText)[1]", name = "Nifty Bank Change")
    public Element niftyBankChange;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty Bank\"]/following-sibling::android.widget.TextView)[2]", name = "Nifty Bank Adv")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Nifty Bank\"]/following-sibling::XCUIElementTypeStaticText)[2]", name = "Nifty Bank Adv")
    public Element niftyBankAdv;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Nifty Bank\"]/following-sibling::android.widget.TextView)[3]", name = "Nifty Bank Dec")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"Nifty Bank\"]/following-sibling::XCUIElementTypeStaticText)[3]", name = "Nifty Bank Dec")
    public Element niftyBankDec;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"All Sectors\"]/preceding-sibling::android.widget.Button", name = "Back Button All Sectors Page")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"All Sectors\"]/preceding-sibling::XCUIElementTypeImage[@name=\"back\"]", name = "Back Button All Sectors Page")
    public Element backButtonAllSectorsPage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"empty_image\"]/following-sibling::android.widget.TextView[@text=\"No stocks hit 52 Week Low today\"]", name = "No stocks hit 52 Week Low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"No stocks hit 52 Week Low today\"]", name = "No stocks hit 52 Week Low")
    public Element noStockHitLow52Week;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"empty_image\"]/following-sibling::android.widget.TextView[@text=\"No stocks hit 52 Week High today\"]", name = "No stocks hit 52 Week High")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"No stocks hit 52 Week High today\"]", name = "No stocks hit 52 Week High")
    public Element noStockHitHigh52Week;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Trending ETFs\"]/preceding-sibling::android.view.View)[last()]", name = "Browse Mutual Fund Banner")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage", name = "Browse Mutual Fund Banner")
    // need to add proper locator
    public Element browseMutualFundBanner;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Trending ETFs\"]", name = "Trending ETF Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Trending ETFs\"]", name = "Trending ETF Heading")
    public Element trendingEtfHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"scrip icon\"]", name = "Etf Icons")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeImage[@name=\"stocks_placeholder\"]", name = "Etf Icons")
    public Elements etfIcons;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"scrip icon\"]/following-sibling::android.widget.TextView)[2]", name = "First Etf Ltp")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"stocks_placeholder\"]/following-sibling::XCUIElementTypeStaticText)[2]", name = "First Etf Ltp")
    public Element firstEtfLtp;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"scrip icon\"]/following-sibling::android.widget.TextView)[3]", name = "First Etf Change in %")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"stocks_placeholder\"]/following-sibling::XCUIElementTypeStaticText)[3]", name = "First Etf Change in %")
    public Element firstEtfChangePercent;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All Trending ETFs\"]", name = "View All Trending Etfs")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All Trending ETFs\"]", name = "View All Trending Etfs")
    public Element viewAllTrendingEtfs;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Trending ETFs\"]/preceding-sibling::android.widget.Button", name = "Back Button Trending Etf")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Trending ETFs\"]/preceding-sibling::XCUIElementTypeImage[@name=\"back\"]", name = "Back Button Trending Etf")
    public Element backButtonTrendingEtf;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"FII & DII Cash Provisional\"]/following-sibling::android.widget.ImageView[@content-desc=\"circle_info\"]", name = "FII DII Cash Provisional info Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"FII & DII Cash Provisional\"]/following-sibling::XCUIElementTypeButton[@name=\"info\"]", name = "FII DII Cash Provisional info Button")
    public Element fiiDiiCashInfoButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"FII & DII Cash Provisional\"]/following-sibling::android.widget.TextView[contains(@text,\"Institutional\")]", name = "FII DII Cash Provisional info Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"FII & DII Cash Provisional\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"Institutional\")]", name = "FII DII Cash Provisional info Text")
    public Element fiiDiiCashInfoText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"FII\"]/following-sibling::android.widget.TextView)[1]", name = "FII Data")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"FII\"]/following-sibling::XCUIElementTypeStaticText)[1]", name = "FII Data")
    public Element fiiData;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"FII\"]/following-sibling::android.widget.TextView[contains(@text,\"FII were net sellers on\")]", name = "FII Seller Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"FII\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"FII were net sellers on\")]\n", name = "FII Seller Text")
    public Element fiiSellerText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"FII\"]/following-sibling::android.widget.TextView[contains(@text,\"FII were net buyers on\")]", name = "FII Buyer Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"FII\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"FII were net buyers on\")]", name = "FII Buyer Text")
    public Element fiiBuyerText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"DII\"]/following-sibling::android.widget.TextView)[1]", name = "DII Data")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"DII\"]/following-sibling::XCUIElementTypeStaticText)[1]", name = "DII Data")
    public Element diiData;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"DII\"]/following-sibling::android.widget.TextView[contains(@text,\"DII were net sellers on\")]", name = "DII Seller Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"DII\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"DII were net sellers on\")]\n", name = "DII Seller Text")
    public Element diiSellerText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"DII\"]/following-sibling::android.widget.TextView[contains(@text,\"DII were net buyers on\")]", name = "DII Buyer Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"DII\"]/following-sibling::XCUIElementTypeStaticText[contains(@name,\"DII were net buyers on\")]\n", name = "DII Buyer Text")
    public Element diiBuyerText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"News\"]", name = "News Heading")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"News\"]", name = "News Heading")
    public Element newsHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"news_thumbnail\"]/following-sibling::android.widget.TextView)[1]", name = "First News Title")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"News\"]/following-sibling::XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText)[1]", name = "First News Title")
    public Element firstNewsTitle;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"news_navigate\"])[1]", name = "news Navigate")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"forward_chevron\"])[1]", name = "news Navigate")
    public Element firstNewsNavigate;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc=\"news_navigate\"]/following-sibling::android.widget.TextView)[1]", name = "news Date Posting")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeStaticText[@name=\"News\"]/following-sibling::XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText)[2]", name = "news Date Posting")
    public Element newsDatePosting;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View All News\"]", name = "View All News Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"View All News\"]", name = "View All News Button")
    public Element viewAllNewsButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"News\"]/preceding-sibling::android.widget.Button", name = "Back Button News Page")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"News\"]/preceding-sibling::XCUIElementTypeImage[@name=\"back\"]", name = "Back Button News Page")
    public Element backButtonNewsPage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"%s\"]", name = "News Page news")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"%s\"]", name = "News Page news")
    public Element newsPage;


    public void clickWatchlistTab() {
        watchlistTab.click();
    }

    public ScripDetailsOverviewPage clickOnScrip() {
        firstScrip.setElementSync(true);
        firstScrip.click();
        return new ScripDetailsOverviewPage();
    }

    public void clickOnTopGainers() {
        topGainers.loadElement();
        topGainers.setElementSync(true);
        topGainers.click();
    }

    public void clickOnTopLosers() {
        topLosers.loadElement();
        topLosers.setElementSync(true);
        topLosers.click();
    }

    public void clickOnWeekHigh() {
        xWeekHigh.loadElement();
        xWeekHigh.setElementSync(true);
        xWeekHigh.click();
    }

    public void clickOnWeekLow() {
        xWeekLow.loadElement();
        xWeekLow.setElementSync(true);
        xWeekLow.click();
    }

    public void clickOnActiveByVol() {
        activeByVolume.loadElement();
        activeByVolume.setElementSync(true);
        activeByVolume.click();
    }

    public void clickViewAllTopGainers() {
        viewAllTopGainers.loadElement();
        viewAllTopGainers.setElementSync(true);
        viewAllTopGainers.click();
    }

    public void clickViewAllTopLosers() {
        viewAllTopLosers.loadElement();
        viewAllTopLosers.setElementSync(true);
        viewAllTopLosers.click();
    }

    public void clickViewAll52WeekHigh() {
        viewAll52WHigh.loadElement();
        viewAll52WHigh.setElementSync(true);
        viewAll52WHigh.click();
    }

    public void clickViewAll52WeekLow() {
        viewAll52WLow.loadElement();
        viewAll52WLow.setElementSync(true);
        viewAll52WLow.click();
    }

    public void clickViewAllActiveByVolume() {
        viewAllActiveByVolume.loadElement();
        viewAllActiveByVolume.setElementSync(true);
        viewAllActiveByVolume.click();
    }

    public void clickViewAllSectors() {
        viewAllSectors.setElementSync(true);
        viewAllSectors.click();
    }

    public void clickViewAllTrendingEtfs() {
        viewAllTrendingEtfs.setElementSync(true);
        viewAllTrendingEtfs.click();
    }

    public static void deviceBackKey() {
        ((AndroidDriver) getLocalDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
