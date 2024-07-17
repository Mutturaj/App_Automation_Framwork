package com.stockBroking.qa.pages.commonNavigationPages;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class NavigationObjects extends BasePage {

    public NavigationObjects() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.view.View[@content-desc='Watchlist'])//parent::android.view.View", name = "Watchlist page")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Watchlist", name = "Watchlist page")
    public Element watchList;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc='WealthBasket]", name = "WealthBasket page")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "WealthBaskets", name = "WealthBasket page")
    public Element wealthBasket;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc='Portfolio]", name = "portfolio page")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Portfolio", name = "portfolio page")
    public Element portfolio;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"watchlist_header\"]/preceding-sibling::android.view.View", name = "profile page")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name='Discover']/preceding-sibling::XCUIElementTypeImage", name = "profile page")
    public Element profile;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"search\"]", name = "search")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "(//XCUIElementTypeImage[@name=\"search\"])[1]", name = "search")
    public Element search;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"notification\"]", name = "notification")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "notification", name = "notification")
    public Element notification;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Market", name = "Market")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Market", name = "Market")
    public Element market;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Discover", name = "Discover tab")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name='Discover']", name = "Discover tab")
    public Element discover;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"close\"]", name = "Close Icon")
    public Element closeIcon;


}
