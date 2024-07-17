package com.stockBroking.qa.appTests.homeTest;

import base.ShareMarketBaseTest;
import com.stockBroking.qa.helpers.LoginHelpers;
import com.stockBroking.qa.pages.commonNavigationPages.NavigationObjects;
import com.stockBroking.qa.pages.homepage.AllIndicesPage;
import com.stockBroking.qa.pages.homepage.MarketPage;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.utils.Helper;
import com.stockBroking.qa.utils.NavigationHelper;
import com.stockBroking.qa.utils.TestUtils;
import com.stockBroking.qa.validators.homeVerifier.HomeVerifier;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends ShareMarketBaseTest {

    private final TestUtils utils;
    private final LoginHelpers loginHelpers;
    private final Helper helper;
    private final HomeVerifier homeVerifier;

    @BeforeMethod
    void preRequisites() throws IOException, InterruptedException, JSONException {
        LoginPage loginPage = new LoginPage();
        if (loginPage.useYourPhonePeAccText.isDisplayed()) {
            loginHelpers.login(loginPage, helper.getTestData("phoneNumber"), helper.getTestData("pin"));
        } else if (loginPage.pinField.isDisplayed()) {
            loginHelpers.enterPasscode(loginPage, helper.getTestData("pin"));
        }
    }

    HomeTest() {
        this.utils = new TestUtils();
        this.loginHelpers = new LoginHelpers();
        this.helper = new Helper();
        this.homeVerifier = new HomeVerifier();
    }

//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Test Description: Validate the Home Page Cards")
//    @Story("Verify Open Demat Banner at top")
//    @Test(description = "Verify Open Demat Banner at top")
//    public void verifyOpenDematBanner() {
//        HomePage homePage = new HomePage();
//        OnboardingPage onboardingPage = new OnboardingPage();
//        homeVerifier.openDematBannerVerifier(homePage, onboardingPage, utils);
//    }
    
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Indices Banner")
    @Test(description = "Verify Indices Banner")
    public void verifyIndicesBanner() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        AllIndicesPage allIndicesPage = new AllIndicesPage();
        homeVerifier.nifty50IndiceVerifier(marketPage, utils);
        marketPage.viewAllIndices.click();
        homeVerifier.AllIndicesScreenVerifier(allIndicesPage, utils);
        allIndicesPage.backButton.click();
        utils.waitForElementToDisplay(marketPage.watchlistTab);
        Assert.assertTrue(marketPage.watchlistTab.isDisplayed());
        //need to add validation apart from nifty 50
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Advances and Declines Card")
    @Test(description = "Verify Advances & Declines")
    public void verifyAdvancesAndDeclinesCard() {
        MarketPage marketPage = new MarketPage();
        homeVerifier.advancesAndDeclinesVerifier(marketPage, utils);
        //will check to validate charts things
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Stock Movement Card")
    @Test(description = "Verify Stock Movement")
    public void verifyStockMovementCard() {
        MarketPage homePage = new MarketPage();
        homeVerifier.defaultStockMovementCardVerifier(homePage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Sectoral Performance Card")
    @Test(description = "Verify Sectoral Performance")
    public void verifySectoralPerformance() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        homeVerifier.sectorPerformanceCardVerifier(marketPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Mutual Fund Banner")
    @Test(description = "Verify Mutual Fund Banner")
    public void verifyMutualFundBanner() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        homeVerifier.mutualFundBannerVerifier(marketPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Trending Etf Card")
    @Test(description = "Verify Trending ETF card")
    public void verifyTrendingEtfCard() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        homeVerifier.trendingETFVerifier(marketPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify FII DII Cash Provision Card")
    @Test(description = "Verify FII DII Cash Provision Card")
    public void verifyFiiDiiCashProvisionCard() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        homeVerifier.fiiDiiCashCardVerifier(marketPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify News Section")
    @Test(description = "Verify News Section")
    public void verifyNewsSection() {
        MarketPage marketPage = new NavigationHelper().goToMarketPage();
        homeVerifier.newsSectionVerifier(marketPage, utils);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Validate the Home Page Cards")
    @Story("Verify Market Elements")
    @Test(description = "Verify Market Elements")
    public void verifyMarketElements() {
        new NavigationHelper().goToMarketPage();
        NavigationObjects navObjects = new NavigationObjects();
        homeVerifier.marketElementsVerifier(navObjects, utils);
    }
}
