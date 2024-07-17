package com.stockBroking.qa.validators.profileVerifier;

import com.stockBroking.qa.pages.profile.HelpPage;
import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;

public class ProfileVerifier {
    public void helpSectionElementsVerifier(HelpPage helpPage, TestUtils utils) {
        utils.waitForElementToDisplay(helpPage.backButtonHelpPage);
        Assert.assertTrue(helpPage.backButtonHelpPage.isDisplayed());
        Assert.assertTrue(helpPage.viewTickets.isDisplayed());
        Assert.assertTrue(helpPage.gettingStartedTopic.isDisplayed());
        Assert.assertTrue(helpPage.tradingInvestmentTopic.isDisplayed());
        Assert.assertTrue(helpPage.portfolioAccountTopic.isDisplayed());
        Assert.assertTrue(helpPage.brokerageRegulatoryTopic.isDisplayed());
        Assert.assertTrue(helpPage.manageFundsTopic.isDisplayed());
        Assert.assertTrue(helpPage.wealthBasketTopic.isDisplayed());
    }
    
    public void gettingStartedSubTopicVerifier(HelpPage helpPage, TestUtils utils) {
        helpPage.gettingStartedTopic.click();
        utils.waitForElementToDisplay(helpPage.gettingStartedSectionHeading);
        Assert.assertTrue(helpPage.gettingStartedSectionHeading.isDisplayed());
        Assert.assertTrue(helpPage.accountOpeningSubTopic.isDisplayed());
        helpPage.accountOpeningSubTopic.click();
        utils.waitForElementToDisplay(helpPage.accountOpeningFirstQuestion);
        Assert.assertTrue(helpPage.accountOpeningFirstQuestion.isDisplayed());
        //unable to validate dropdown and answer as no locator is there
    }

    public void botVerifier(HelpPage helpPage, TestUtils utils) {
        utils.waitForElementToDisplay(helpPage.contactSupport);
        Assert.assertTrue(helpPage.contactSupport.isDisplayed());
        helpPage.contactSupport.click();
        utils.waitForElementToDisplay(helpPage.whatCanIHelpText);
        Assert.assertTrue(helpPage.whatCanIHelpText.isDisplayed());
        Assert.assertTrue(helpPage.backButtonSupportPage.isDisplayed());
        helpPage.openingTradeDematBotQuestion.click();
        utils.waitForElementToDisplay(helpPage.goBackButton);
        Assert.assertTrue(helpPage.goBackButton.isDisplayed());
        Assert.assertTrue(helpPage.needMoreHelpText.isDisplayed());
        Assert.assertTrue(helpPage.emailBotSuggestion.isDisplayed());
        helpPage.emailBotSuggestion.click();
        utils.waitForElementToDisplay(helpPage.unableToUseEmailSuggestion);
        helpPage.unableToUseEmailSuggestion.click();
        utils.waitForElementToDisplay(helpPage.noBotSuggestion);
        helpPage.noBotSuggestion.click();
        utils.waitForElementToDisplay(helpPage.thankYouText);
        Assert.assertTrue(helpPage.thankYouText.isDisplayed());
    }
}
