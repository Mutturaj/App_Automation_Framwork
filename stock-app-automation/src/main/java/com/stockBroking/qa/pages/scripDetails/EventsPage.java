package com.stockBroking.qa.pages.scripDetails;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;
import static listner.ThreadCreator.getLocalDriver;

public class EventsPage extends BasePage {

    public EventsPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Dividends\"]", name = "Dividends")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Dividends")
    public Element dividends;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Bonus\"]", name = "Bonus")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Bonus")
    public Element bonus;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Splits\"]", name = "Splits")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Splits")
    public Element splits;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Board Meetings\"]", name = "Board meetings")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Board meetings")
    public Element boardMeetings;
}
