package com.stockBroking.qa.validators.homeVerifier;

import com.stockBroking.qa.pages.commonNavigationPages.NavigationObjects;
import com.stockBroking.qa.pages.homepage.AllIndicesPage;
import com.stockBroking.qa.pages.homepage.MarketPage;
import com.stockBroking.qa.pages.onboarding.OnboardingPage;
import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;
import pagefactory.elements.Element;

public class HomeVerifier {

    public void openDematBannerVerifier(MarketPage homePage, OnboardingPage onboardingPage, TestUtils utils) {
        utils.waitForElementToDisplay(homePage.openDematBanner);
        Assert.assertTrue(homePage.openDematBanner.isDisplayed());
        homePage.openDematBanner.click();
        utils.waitForElementToDisplay(onboardingPage.onboardingScreenText);
        Assert.assertTrue(onboardingPage.onboardingScreenText.isDisplayed());
        Assert.assertTrue(onboardingPage.openAccount.isDisplayed());
    }

    public void nifty50IndiceVerifier(MarketPage homePage, TestUtils utils) {
        utils.waitForElementToDisplay(homePage.indicesHeading);
        Assert.assertTrue(homePage.indicesHeading.isDisplayed());
        Assert.assertTrue(homePage.nifty50Index.isDisplayed());
        Assert.assertTrue(utils.isNumeric(homePage.niftyLtp.getText().replace(",", "")));
        String niftyChange = homePage.niftyPerChange.getText();
        Assert.assertTrue(utils.isNumeric(niftyChange.substring(1, niftyChange.indexOf('('))));
        Assert.assertTrue(utils.isNumeric(niftyChange.substring(niftyChange.indexOf('(') + 2, niftyChange.indexOf('%'))));
        String advPercent = homePage.advPercent.getText();
        String decPercent = homePage.decPercent.getText();
        Assert.assertTrue(utils.isNumeric(advPercent.substring(0, advPercent.indexOf('%'))));
        Assert.assertTrue(utils.isNumeric(decPercent.substring(0, decPercent.indexOf('%'))));
        Assert.assertTrue(homePage.advLabelNifty50.isDisplayed());
        Assert.assertTrue(homePage.bseSensexIndex.isDisplayed());
        utils.scrollHorizontallyTillElement(homePage.nifty50Index, homePage.niftyBankIndex);
        Assert.assertTrue(homePage.niftyBankIndex.isDisplayed());
        utils.scrollHorizontallyTillElement(homePage.niftyBankIndex, homePage.viewAllIndices);
        Assert.assertTrue(homePage.viewAllIndices.isDisplayed());
    }

    public void AllIndicesScreenVerifier(AllIndicesPage allIndicesPage, TestUtils utils) {
        utils.waitForElementToDisplay(allIndicesPage.nseTab);
        Assert.assertTrue(allIndicesPage.nseTab.isDisplayed());
        Assert.assertTrue(allIndicesPage.bseTab.isDisplayed());
        Assert.assertTrue(allIndicesPage.allIndicesScreenHeading.isDisplayed());
        Assert.assertTrue(allIndicesPage.nifty50Index.isDisplayed());
        Assert.assertTrue(allIndicesPage.oneDay.isDisplayed());
        Assert.assertTrue(allIndicesPage.oneMonth.isDisplayed());
        Assert.assertTrue(allIndicesPage.oneWeek.isDisplayed());
        Assert.assertTrue(allIndicesPage.oneYear.isDisplayed());
        allIndicesPage.bseTab.click();
        utils.waitForElementToDisplay(allIndicesPage.bseSensexIndex);
        Assert.assertTrue(allIndicesPage.bseSensexIndex.isDisplayed());
        Assert.assertFalse(allIndicesPage.niftyBankIndex.isDisplayed());
    }

    public void advancesAndDeclinesVerifier(MarketPage homePage, TestUtils utils) {
        utils.waitForElementToDisplay(homePage.watchlistTab);
        utils.scrollVerticallyTillElement(homePage.advancesAndDeclinesHeading);
        Assert.assertTrue(homePage.advancesAndDeclinesHeading.isDisplayed());
        homePage.advancesAndDeclineInfoButton.click();
        utils.waitForElementToDisplay(homePage.advancesAndDeclineInfoPopup);
        Assert.assertTrue(homePage.advancesAndDeclineInfoPopup.isDisplayed());
        utils.deviceBackKey();
        utils.scrollVerticallyTillElement(homePage.advancesLabel);
        Assert.assertTrue(utils.isInteger(homePage.greaterThan5Count.getText()));
        Assert.assertTrue(utils.isInteger(homePage.between5To2Count.getText()));
        Assert.assertTrue(utils.isInteger(homePage.between2To0Count.getText()));
        Assert.assertTrue(utils.isInteger(homePage.zeroCount.getText()));
        Assert.assertTrue(utils.isInteger(homePage.between0ToMinus2.getText()));
        Assert.assertTrue(utils.isInteger(homePage.betweenMinus2ToMinus5.getText()));
        Assert.assertTrue(utils.isInteger(homePage.greaterThanMinus5.getText()));
        String advancesLabel = homePage.advancesLabel.getText();
        String declinesLabel = homePage.declinesLabel.getText();
        Assert.assertTrue(utils.isNumeric(advancesLabel.substring(advancesLabel.indexOf(':') + 2)));
        Assert.assertTrue(utils.isNumeric(declinesLabel.substring(declinesLabel.indexOf(':') + 2)));
    }

    public void defaultStockMovementCardVerifier(MarketPage homePage, TestUtils utils) {
        utils.waitForElementToDisplay(homePage.watchlistTab);
        utils.scrollVerticallyTillElement(homePage.stockMarketCardHeading);
        Assert.assertTrue(homePage.stockMarketCardHeading.isDisplayed());
        utils.scrollVerticallyTillElement(homePage.viewAllTopGainers);
        Assert.assertTrue(homePage.companyColumn.isDisplayed());
        Assert.assertTrue(homePage.todayChangeColumn.isDisplayed());
        Assert.assertTrue(homePage.ltpColumn.isDisplayed());
        utils.slowScrollVerticallyTillElement(homePage.viewAllTopGainers);
        Assert.assertTrue(homePage.viewAllTopGainers.isDisplayed());
        for (Element ele : homePage.scripPerChangeInStockMovement.getElements()) {
            String stockPer = ele.getText();
            Assert.assertTrue(utils.isNumeric(stockPer.substring(stockPer.indexOf('+') + 1, stockPer.indexOf('%'))));
        }
        for (Element ele : homePage.scripPositiveChange.getElements()) {
            String stockLtp = ele.getText();
            Assert.assertTrue(utils.isNumeric(stockLtp.substring(stockLtp.indexOf('+') + 1)));
        }
        homePage.clickViewAllTopGainers();
        utils.waitForElementToDisplay(homePage.backButtonStockMovementPage);
        Assert.assertTrue(homePage.oneDay.isDisplayed());
        Assert.assertTrue(homePage.oneWeek.isDisplayed());
        Assert.assertTrue(homePage.oneMonth.isDisplayed());
        Assert.assertTrue(homePage.oneYear.isDisplayed());
        String topGainersPer = homePage.firstScripPerChange.getText();
        Assert.assertTrue(utils.isNumeric(topGainersPer.substring(topGainersPer.indexOf('+') + 1, topGainersPer.indexOf('%'))));
        homePage.clickOnTopLosers();
        utils.loadUntilElementFound(homePage.oneDay);
        homePage.firstScripPerChange.loadElement();
        String topLosersPer = homePage.firstScripPerChange.getText();
        Assert.assertTrue(utils.isNumeric(topLosersPer.substring(topLosersPer.indexOf('-') + 1, topLosersPer.indexOf('%'))));
        homePage.clickOnWeekHigh();
        homePage.oneDay.loadElement();
        Assert.assertFalse(homePage.oneDay.isDisplayed());
        homePage.firstScripPerChange.loadElement();
        if (homePage.firstScripPerChange.isDisplayed()) {
            String xWeekHigh = homePage.firstScripPerChange.getText();
            Assert.assertTrue(utils.isNumeric(xWeekHigh.substring(xWeekHigh.indexOf('+') + 1, xWeekHigh.indexOf('%'))));
        } else
            Assert.assertTrue(homePage.noStockHitHigh52Week.isDisplayed());
        homePage.clickOnWeekLow();
        homePage.oneDay.loadElement();
        Assert.assertFalse(homePage.oneDay.isDisplayed());
        homePage.firstScripPerChange.loadElement();
        if (homePage.firstScripPerChange.isDisplayed()) {
            String xWeekLow = homePage.firstScripPerChange.getText();
            Assert.assertTrue(utils.isNumeric(xWeekLow.substring(xWeekLow.indexOf('-') + 1, xWeekLow.indexOf('%'))));
        } else
            Assert.assertTrue(homePage.noStockHitLow52Week.isDisplayed());
        homePage.clickOnActiveByVol();
        utils.waitForElementToDisplay(homePage.volumeInCrColumn);
        Assert.assertTrue(homePage.volumeInCrColumn.isDisplayed());
        homePage.oneMonth.loadElement();
        Assert.assertTrue(homePage.oneMonth.isDisplayed());
        homePage.oneYear.loadElement();
        Assert.assertFalse(homePage.oneYear.isDisplayed());
        homePage.backButtonStockMovementPage.click();
        utils.loadUntilElementFound(homePage.stockMarketCardHeading);
        utils.waitForElementToDisplay(homePage.stockMarketCardHeading);
        homePage.clickOnTopLosers();
        utils.waitForElementToDisplay(homePage.viewAllTopLosers);
        Assert.assertTrue(homePage.viewAllTopLosers.isDisplayed());
        homePage.clickOnWeekHigh();
        utils.waitForElementToDisplay(homePage.viewAll52WHigh);
        Assert.assertTrue(homePage.viewAll52WHigh.isDisplayed());
        homePage.clickOnWeekLow();
        utils.waitForElementToDisplay(homePage.viewAll52WLow);
        Assert.assertTrue(homePage.viewAll52WLow.isDisplayed());
        homePage.clickOnActiveByVol();
        utils.waitForElementToDisplay(homePage.viewAllActiveByVolume);
        Assert.assertTrue(homePage.viewAllActiveByVolume.isDisplayed());
    }

    public void sectorPerformanceCardVerifier(MarketPage homePage, TestUtils utils) {
        utils.scrollVerticallyTillElement(homePage.sectoralPerformanceHeading);
        Assert.assertTrue(homePage.sectoralPerformanceHeading.isDisplayed());
        utils.scrollVerticallyTillElement(homePage.viewAllSectors);
        Assert.assertTrue(homePage.sectorColumn.isDisplayed());
        Assert.assertTrue(homePage.changePercentColumn.isDisplayed());
        Assert.assertTrue(homePage.advDecColumn.isDisplayed());
        String niftyBankChange = homePage.niftyBankChange.getText();
        String niftyBankAdv = homePage.niftyBankAdv.getText();
        String niftyBankDec = homePage.niftyBankDec.getText();
        System.out.println(niftyBankChange);
        if (niftyBankChange.contains("+"))
            Assert.assertTrue(utils.isNumeric(niftyBankChange.substring(niftyBankChange.indexOf('+'), niftyBankChange.indexOf('%'))));
        else
            Assert.assertTrue(utils.isNumeric(niftyBankChange.substring(niftyBankChange.indexOf('-'), niftyBankChange.indexOf('%'))));
        Assert.assertTrue(utils.isNumeric(niftyBankAdv.substring(0, niftyBankAdv.indexOf('%'))));
        Assert.assertTrue(utils.isNumeric(niftyBankDec.substring(0, niftyBankDec.indexOf('%'))));
        utils.scrollVerticallyTillElement(homePage.viewAllSectors);
        homePage.clickViewAllSectors();
        utils.waitForElementToDisplay(homePage.backButtonAllSectorsPage);
        Assert.assertTrue(homePage.backButtonAllSectorsPage.isDisplayed());
        homePage.niftyBankChange.loadElement();
        Assert.assertTrue(homePage.niftyBankChange.isDisplayed());
    }

    public void mutualFundBannerVerifier(MarketPage homePage, TestUtils utils) {
        utils.scrollVerticallyTillElement(homePage.browseMutualFundBanner);
        Assert.assertTrue(homePage.browseMutualFundBanner.isDisplayed());
    }

    public void trendingETFVerifier(MarketPage homePage, TestUtils utils) {
        utils.scrollVerticallyTillElement(homePage.trendingEtfHeading);
        Assert.assertTrue(homePage.trendingEtfHeading.isDisplayed());
        utils.scrollVerticallyTillElement(homePage.viewAllTrendingEtfs);
        Assert.assertEquals(homePage.etfIcons.getElements().size(), 4);
        String etfLtp = homePage.firstEtfLtp.getText();
        String etfChange = homePage.firstEtfChangePercent.getText();
        Assert.assertTrue(utils.isNumeric(etfLtp));
        if (etfChange.contains("+")) {
            Assert.assertTrue(utils.isNumeric(etfChange.substring(etfChange.indexOf('+') + 1, etfChange.indexOf('(') - 1)));
        } else {
            Assert.assertTrue(utils.isNumeric(etfChange.substring(etfChange.indexOf('-') + 1, etfChange.indexOf('(') - 1)));
        }
        Assert.assertTrue(utils.isNumeric(etfChange.substring(etfChange.indexOf('(') + 2, etfChange.indexOf('%'))));
        utils.scrollVerticallyTillElement(homePage.viewAllTrendingEtfs);
        homePage.clickViewAllTrendingEtfs();
        utils.waitForElementToDisplay(homePage.backButtonTrendingEtf);
        Assert.assertTrue(homePage.backButtonTrendingEtf.isDisplayed());
        Assert.assertTrue(homePage.firstScrip.isDisplayed());
    }

    public void fiiDiiCashCardVerifier(MarketPage homePage, TestUtils utils) {
        utils.scrollVerticallyTillElement(homePage.fiiDiiCashInfoButton);
        Assert.assertTrue(homePage.fiiDiiCashInfoButton.isDisplayed());
        homePage.fiiDiiCashInfoButton.click();
        utils.waitForElementToDisplay(homePage.fiiDiiCashInfoText);
        Assert.assertTrue(homePage.fiiDiiCashInfoText.isDisplayed());
        utils.deviceBackKey();
        String fiiData = homePage.fiiData.getText();
        String diiData = homePage.diiData.getText();
        Assert.assertTrue(fiiData.contains("Cr"));
        Assert.assertTrue(diiData.contains("Cr"));
        if (fiiData.contains("-"))
            Assert.assertTrue(homePage.fiiSellerText.isDisplayed());
        else
            Assert.assertTrue(homePage.fiiBuyerText.isDisplayed());
        if (diiData.contains("-")) {
            utils.scrollVerticallyTillElement(homePage.diiSellerText);
            Assert.assertTrue(homePage.diiSellerText.isDisplayed());
        } else {
            utils.scrollVerticallyTillElement(homePage.diiSellerText);
            Assert.assertTrue(homePage.diiBuyerText.isDisplayed());
        }
        System.out.println(fiiData);
        System.out.println(diiData);
        Assert.assertTrue(utils.isNumeric(fiiData.replace(",","").substring(fiiData.indexOf('₹') + 1, fiiData.indexOf('C') - 1)));
        Assert.assertTrue(utils.isNumeric(diiData.replace(",","").substring(diiData.indexOf('₹') + 1, diiData.indexOf('C') - 1)));
    }

    public void newsSectionVerifier(MarketPage homePage, TestUtils utils) {
        utils.scrollVerticallyTillElement(homePage.newsHeading);
        Assert.assertTrue(homePage.newsHeading.isDisplayed());
        String firstNewsTitle = homePage.firstNewsTitle.getAttribute("text");
        Assert.assertNotNull(firstNewsTitle);
        String date = homePage.newsDatePosting.getText();
        Assert.assertTrue(utils.dateValidator(date.substring(date.indexOf('|') + 2)));
        homePage.firstNewsNavigate.click();
        utils.waitForElementToDisplay(homePage.backButtonNewsPage);
        Assert.assertTrue(homePage.backButtonNewsPage.isDisplayed());
        homePage.newsPage.setMobileRegex(new String[]{firstNewsTitle.replace('\'', '’').replace("  ", " ")});
        utils.waitForElementToDisplay(homePage.newsPage);
        Assert.assertTrue(homePage.newsPage.isDisplayed());
        homePage.backButtonNewsPage.click();
        utils.waitForElementToDisplay(homePage.watchlistTab);
        utils.scrollVerticallyTillElement(homePage.viewAllNewsButton);
        homePage.viewAllNewsButton.click();
        utils.loadUntilElementFound(homePage.backButtonNewsPage);
        homePage.firstNewsNavigate.loadElement();
        Assert.assertTrue(homePage.firstNewsNavigate.isDisplayed());
    }

    public void marketElementsVerifier(NavigationObjects navObjects, TestUtils utils) {
        utils.waitForElementToDisplay(navObjects.profile);
        Assert.assertTrue(navObjects.profile.isDisplayed());
        Assert.assertTrue(navObjects.search.isDisplayed());
        Assert.assertTrue(navObjects.notification.isDisplayed());
    }
}