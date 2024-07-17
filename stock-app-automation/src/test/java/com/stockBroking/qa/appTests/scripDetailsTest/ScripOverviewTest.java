package com.stockBroking.qa.appTests.scripDetailsTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.homepage.MarketPage;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.pages.scripDetails.ScripDetailsOverviewPage;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.TestUtils;
import com.stockBroking.qa.validators.scripValidator.OverviewVerifier;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class ScripOverviewTest extends ShareMarketBaseTest  {

    private final OverviewVerifier overviewVerifier;
    private final LoginHelpers loginHelpers;
    private final Helper helper;
    private final TestUtils testUtils;

    public ScripOverviewTest(){
        this.overviewVerifier =new OverviewVerifier();
        this.loginHelpers =  new LoginHelpers();
        this.helper =  new Helper();
        this.testUtils = new TestUtils();
    }

    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        if (loginPage.useYourPhonePeAccText.isDisplayed()) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        } else if (loginPage.pinField.isDisplayed()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify user is able to select Script")
    @Story("Verify user is able to select Script")
    @Test(description = "Verify user is able to select Script")
    void testOverview(){
        MarketPage homePage = new MarketPage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        overviewVerifier.overviewPageVerifier(homePage.clickOnScrip());
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify the options present in Script")
    @Story("Verify the options present in Script")
    @Test(description = "Verify the options present in Script")
    void testScripDetailsUi(){
        MarketPage homePage = new MarketPage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        overviewVerifier.scripDetailsPageVerifier(homePage.clickOnScrip(), testUtils);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify the options present in Script")
    @Story("Verify the options present in Script")
    @Test(description = "Verify the options present in Script")
    void testScripOverviewUi(){
        MarketPage homePage = new MarketPage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        ScripDetailsOverviewPage scripDetailsOverviewPage = homePage.clickOnScrip();
        overviewVerifier.overViewVerifier(scripDetailsOverviewPage, testUtils);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify the options present in Script")
    @Story("Verify the options present in Script")
    @Test(description = "Verify the options present in Script")
    void testLineChart(){
        MarketPage homePage = new MarketPage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        ScripDetailsOverviewPage scripDetailsOverviewPage = homePage.clickOnScrip();
        overviewVerifier.lineChartVerifier(scripDetailsOverviewPage, testUtils);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Verify the options present in Script")
    @Story("Verify the options present in Script")
    @Test(description = "Verify the options present in Script")
    void testScripDetailsPageLoadTime(){
        //later
 /*       HomePage homePage = new HomePage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        long firstLoadTime = testUtils.measurePageLoadTime();
        ScripDetailsOverviewPage scripDetailsOverviewPage = homePage.clickOnScrip();
        scripDetailsOverviewPage.backToHomePageFromScripDetails();
        ScripDetailsOverviewPage scripDetailsOverviewPage1 = homePage.clickOnScrip();
        long secondLoadTime = testUtils.measurePageLoadTime();*/
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: market depth")
    @Story("Verify the market depth on the scrip overview page")
    @Test(description = "Verify the market depth on the scrip overview page")
    void testMarketDepth(){
        MarketPage homePage = new MarketPage();
        testUtils.scrollVerticallyTillElement(homePage.firstScrip);
        ScripDetailsOverviewPage scripDetailsOverviewPage = homePage.clickOnScrip();

    }

}
