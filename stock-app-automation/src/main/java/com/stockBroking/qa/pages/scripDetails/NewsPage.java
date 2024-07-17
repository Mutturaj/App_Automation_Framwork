package com.stockBroking.qa.pages.scripDetails;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class NewsPage extends BasePage {

    public NewsPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"News\"])[1]", name = "News")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "News")
    public Element news;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"News\"])[1]", name = "Corporate Announcement")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Corporate Announcement")
    public Element corporateAnnouncement;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Reports\"]", name = "Reports")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Reports")
    public Element reports;

}
