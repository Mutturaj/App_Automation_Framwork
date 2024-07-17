package com.stockBroking.qa.pages.scripDetails;

import com.stockBroking.qa.pages.orderFlow.OrderPage;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class ChartsPage extends BasePage {

    public ChartsPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "News")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "News")
    public Element news;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='BUY']", name = "BUY button")
    public Element buyButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='SELL']", name = "SELL button")
    public Element sellButton;

    public OrderPage clickBuyButton() {
        buyButton.setElementSync(true);
        buyButton.click();
        return new OrderPage();
    }


}
