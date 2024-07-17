package com.stockBroking.qa.pages.profile;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class ProfilePage extends BasePage {

    public ProfilePage() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc='manage account navigation']", name = "Manage your phonepe accounts")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//XCUIElementTypeStaticText[@name=\"Manage Your PhonePe Account\"]", name = "Manage your phonepe accounts")
    public Element managePhonePeAccounts;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//(//android.widget.TextView[@text=\"Preferences\"]/preceding-sibling::android.widget.Button)[last()]", name = "Help Button")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Help", name = "Help")
    public Element helpButton;

    public PhonePeAccountsPage clickOnManagePhonePeAccounts() {
        managePhonePeAccounts.click();
        return new PhonePeAccountsPage();
    }

    public HelpPage openHelpSection() {
        helpButton.setElementSync(true);
        helpButton.click();
        return new HelpPage();
    }
}
