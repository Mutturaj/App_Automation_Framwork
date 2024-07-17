package com.stockBroking.qa.pages.PortFolio;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class PortfolioPage extends BasePage {

    public PortfolioPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()),this);
    }
}
