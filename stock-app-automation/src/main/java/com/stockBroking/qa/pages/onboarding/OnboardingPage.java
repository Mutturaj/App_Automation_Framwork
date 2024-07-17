package com.stockBroking.qa.pages.onboarding;

import listner.ThreadCreator;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

public class OnboardingPage extends BasePage {

    public OnboardingPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Open Your Free Demat & Trading Account']", name = "OnboardingPage Screen Text")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Open Your Free Demat & Trading Account\"]", name = "OnboardingPage Screen Text")
    public Element onboardingScreenText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='OPEN ACCOUNT NOW']", name = "Open Account Button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeButton[@name=\"OPEN ACCOUNT NOW\"]", name = "Open Account Button")
    public Element openAccount;
}
