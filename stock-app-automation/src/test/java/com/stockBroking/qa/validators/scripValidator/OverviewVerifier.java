package com.stockBroking.qa.validators.scripValidator;

import com.stockBroking.qa.pages.scripDetails.EventsPage;
import com.stockBroking.qa.pages.scripDetails.NewsPage;
import com.stockBroking.qa.pages.scripDetails.ScripDetailsOverviewPage;
import com.stockBroking.qa.utils.TestUtils;
import org.testng.Assert;

import static listner.ThreadCreator.getUiSoftAssert;

public class OverviewVerifier {

    public void overviewPageVerifier(ScripDetailsOverviewPage scripDetailsOverviewPage) {
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.scripName, "Checking scrip name on overview");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.scripPrice, "Checking scrip price on overview page");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.scripPriceTrends, "Checking scrip price trend on overview page");
    }

    public void scripDetailsPageVerifier(ScripDetailsOverviewPage scripDetailsOverviewPage,
                                         TestUtils testUtils) {
        Assert.assertTrue(testUtils.isClickable(scripDetailsOverviewPage.exchangeToggle));
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.overview, "Checking overview");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.chart, "Checking chart");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.fundamentals, "Checking chart");
        testUtils.scrollHorizontallyTillElement(scripDetailsOverviewPage.fundamentals, scripDetailsOverviewPage.news);
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.technicals, "Checking technicals");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.events, "Checking events");
        EventsPage eventsPage = scripDetailsOverviewPage.goToEvents();
        getUiSoftAssert().assertElementIsDisplayed(eventsPage.dividends, "Checking dividends");
        getUiSoftAssert().assertElementIsDisplayed(eventsPage.bonus, "Checking bonus");
        getUiSoftAssert().assertElementIsDisplayed(eventsPage.splits, "Checking splits");
        getUiSoftAssert().assertElementIsDisplayed(eventsPage.boardMeetings, "Checking boardMeetings");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.news, "Checking news");
        NewsPage newsPage = scripDetailsOverviewPage.goToNews();
        getUiSoftAssert().assertElementIsDisplayed(newsPage.news, "Checking news");
        getUiSoftAssert().assertElementIsDisplayed(newsPage.corporateAnnouncement, "Checking corporateAnnouncement");
        getUiSoftAssert().assertElementIsDisplayed(newsPage.reports, "Checking reports");
        getUiSoftAssert().assertElementIsDisplayed(scripDetailsOverviewPage.related, "Checking related");
    }

    public void overViewVerifier(ScripDetailsOverviewPage scripDetailsOverviewPage,
                                 TestUtils testUtils) {
        Assert.assertTrue(scripDetailsOverviewPage.lineChart.isDisplayed(), "Checking line chart graph");
        testUtils.scrollVerticallyTillElement(scripDetailsOverviewPage.volume);
        Assert.assertTrue(scripDetailsOverviewPage.openPrice.isDisplayed(), "Checking open price");
        Assert.assertNotNull(scripDetailsOverviewPage.openPrice.getText(), "checking open price value, should not be null");
        Assert.assertTrue(scripDetailsOverviewPage.prevClose.isDisplayed(), "Checking pre closed, is displayed");
        Assert.assertNotNull(scripDetailsOverviewPage.prevClose.getText(), "Checking pre closed value, should not be null");
        Assert.assertTrue(scripDetailsOverviewPage.volume.isDisplayed(), "Checking volume, should be displayed");
        Assert.assertNotNull(scripDetailsOverviewPage.volume.getText(), "Checking volume, should not be null");
        Assert.assertTrue(scripDetailsOverviewPage.avgTradePrice.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.avgTradePrice.getText());
        Assert.assertTrue(scripDetailsOverviewPage.upperCircuit.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.upperCircuit.getText());
        Assert.assertTrue(scripDetailsOverviewPage.lowerCircuit.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.lowerCircuit.getText());
        Assert.assertTrue(scripDetailsOverviewPage.todayHigh.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.todayHigh.getText());
        Assert.assertTrue(scripDetailsOverviewPage.todayLow.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.todayLow.getText());
        testUtils.scrollVerticallyTillElement(scripDetailsOverviewPage.marketDepth);
        Assert.assertTrue(scripDetailsOverviewPage.marketDepthBuyOrder.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.marketDepthBuyOrder.getText());
        Assert.assertTrue(scripDetailsOverviewPage.marketDepthSellOrder.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.marketDepthSellOrder.getText());
        Assert.assertTrue(scripDetailsOverviewPage.marketDepthTotalBuy.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.marketDepthTotalBuy.getText());
        Assert.assertTrue(scripDetailsOverviewPage.marketDepthTotalSell.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.marketDepthTotalSell.getText());
        testUtils.scrollVerticallyTillElement(scripDetailsOverviewPage.analystRecommendations);
        Assert.assertTrue(scripDetailsOverviewPage.analystRecommendationsBuyPercentage.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.analystRecommendationsBuyPercentage.getText());
        Assert.assertTrue(scripDetailsOverviewPage.analystRecommendationsHoldPercentage.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.analystRecommendationsHoldPercentage.getText());
        Assert.assertTrue(scripDetailsOverviewPage.analystRecommendationsSellPercentage.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.analystRecommendationsSellPercentage.getText());
        testUtils.scrollVerticallyTillElement(scripDetailsOverviewPage.pastPerformance);
        Assert.assertTrue(scripDetailsOverviewPage.pastPerformance52WeekHigh.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.pastPerformance52WeekHigh.getText());
        Assert.assertTrue(scripDetailsOverviewPage.pastPerformance52WeekLow.isDisplayed());
        Assert.assertNotNull(scripDetailsOverviewPage.pastPerformance52WeekLow.getText());
    }

    public void lineChartVerifier(ScripDetailsOverviewPage scripDetailsOverviewPage,
                                  TestUtils testUtils) {
        Assert.assertTrue(scripDetailsOverviewPage.lineChart.isDisplayed());
        Assert.assertTrue(scripDetailsOverviewPage.lineChart1Day.isEnabled());
        scripDetailsOverviewPage.lineChart1Day.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChart5Day.isEnabled());
        scripDetailsOverviewPage.lineChart5Day.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChart1Month.isEnabled());
        scripDetailsOverviewPage.lineChart1Month.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChart3Month.isEnabled());
        scripDetailsOverviewPage.lineChart3Month.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChartYtd.isEnabled());
        scripDetailsOverviewPage.lineChartYtd.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChart1Y.isEnabled());
        scripDetailsOverviewPage.lineChart1Y.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChart5Y.isEnabled());
        scripDetailsOverviewPage.lineChart5Y.click();
        Assert.assertTrue(scripDetailsOverviewPage.lineChartAll.isEnabled());
        scripDetailsOverviewPage.lineChartAll.click();
    }

}
