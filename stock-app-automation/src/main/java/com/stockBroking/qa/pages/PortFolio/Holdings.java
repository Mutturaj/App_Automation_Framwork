package com.stockBroking.qa.pages.PortFolio;

import org.openqa.selenium.WebDriver;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class Holdings extends BasePage {


    public Holdings() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }


}
