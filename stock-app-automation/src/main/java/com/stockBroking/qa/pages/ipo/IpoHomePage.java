package com.stockBroking.qa.pages.ipo;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;
import static listner.ThreadCreator.getLocalDriver;

public class IpoHomePage extends BasePage {

    public IpoHomePage() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()),this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "List of Active IPO")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "List of Active IPO")
    public Element listOfActiveIpo;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name = "Listed IPO")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name = "Listed IPO")
    public Element listedIpo;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name="")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name = "")
    public Element upcomingIpo;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name = "No active ipo")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name = "No active ipo")
    public Element noActiveIpo;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name = "List of upcoming Ipo")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name = "List of upcoming Ipo")
    public Element listOfUpcomingIpo;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name = "minimum Investment amount")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name = "minimum Investment amount")
    public Element minimumInvestment;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name ="price range")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name ="price range")
    public Element priceRage;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name ="current status")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name ="current status")
    public Element currentStatus;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "", name ="subscription trends")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "", name ="subscription trends")
    public Element subscriptionTrends;

}
