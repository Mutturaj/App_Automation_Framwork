package com.stockBroking.qa.pages.profile;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class PhonePeAccountsPage extends BasePage {

    public PhonePeAccountsPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@text='Change Passcode']", name = "change password")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Change Passcode", name = "Change Passcode")
    public Element changePassword;

    public ForgotPasswordPage clickOnChangePassword(){
        changePassword.click();
        return new ForgotPasswordPage();
    }

}
