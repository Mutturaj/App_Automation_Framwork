package com.stockBroking.qa.pages.discover;

import listner.ThreadCreator;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.proxy.PageFieldDesigner;

public class DiscoverPage extends BasePage {

    public DiscoverPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }
}
