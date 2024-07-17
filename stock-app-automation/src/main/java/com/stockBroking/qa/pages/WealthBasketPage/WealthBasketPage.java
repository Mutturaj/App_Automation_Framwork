package com.stockBroking.qa.pages.WealthBasketPage;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class WealthBasketPage extends BasePage {

    public WealthBasketPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }
}
