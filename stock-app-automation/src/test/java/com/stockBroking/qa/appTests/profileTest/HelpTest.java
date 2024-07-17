package com.stockBroking.qa.appTests.profileTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.pages.profile.HelpPage;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.NavigationHelper;
import com.stockBroking.qa.utils.TestUtils;
import com.stockBroking.qa.validators.profileVerifier.ProfileVerifier;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HelpTest extends ShareMarketBaseTest {
    private final TestUtils utils;
    private final LoginHelpers loginHelpers;
    private final Helper helper;
    private final ProfileVerifier profileVerifier;

    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException, JSONException {
        LoginPage loginPage = new LoginPage();
        if (loginPage.useYourPhonePeAccText.isDisplayed()) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        } else if (loginPage.pinField.isDisplayed()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
    }

    HelpTest() {
        this.utils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.helper = new Helper();
        this.profileVerifier = new ProfileVerifier();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify Help Section")
    @Story("Verify Help Section Elements")
    @Test(description = "Verify Help Section Elements")
    public void verifyHelpSectionElements() {
        NavigationHelper navigationHelper = new NavigationHelper();
        HelpPage helpPage = navigationHelper.goToProfile().openHelpSection();
        profileVerifier.helpSectionElementsVerifier(helpPage, utils);
        profileVerifier.gettingStartedSubTopicVerifier(helpPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify Help Section")
    @Story("Verify Contact Support on Help Page")
    @Test(description = "Verify Bot on Help Page")
    public void verifySupportBot() {
        NavigationHelper navigationHelper = new NavigationHelper();
        HelpPage helpPage = navigationHelper.goToProfile().openHelpSection();
        profileVerifier.botVerifier(helpPage, utils);
    }
}
