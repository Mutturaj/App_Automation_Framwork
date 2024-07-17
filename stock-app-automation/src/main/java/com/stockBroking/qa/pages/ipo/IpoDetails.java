package com.stockBroking.qa.pages.ipo;

import org.openqa.selenium.WebDriver;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class IpoDetails extends BasePage {

    public IpoDetails() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()),this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "IPO company name")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "IPO company name")
    public Element ipoCompanyName;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Blockbuster bidding ongoing")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Blockbuster bidding ongoing")
    public Element blockbusterBiddingOngoing;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Bidding To And From Date")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Bidding To And From Date")
    public Element biddingToAndFromDate;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Application upcoming/closing remaining time")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Application upcoming/closing remaining time")
    public Element upcomingClosingTime;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Total subscription")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Total subscription")
    public Element totalSubscription;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Apply now")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Apply now")
    public Element applyNow;


}
