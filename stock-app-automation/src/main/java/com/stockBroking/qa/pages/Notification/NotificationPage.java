package com.stockBroking.qa.pages.Notification;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class NotificationPage extends BasePage {

    public NotificationPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }
}
