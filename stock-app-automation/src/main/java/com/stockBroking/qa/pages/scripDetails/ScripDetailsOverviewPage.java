package com.stockBroking.qa.pages.scripDetails;

import com.stockBroking.qa.pages.homepage.MarketPage;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;
import static listner.ThreadCreator.getLocalDriver;

public class ScripDetailsOverviewPage extends BasePage {

    public ScripDetailsOverviewPage() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_scrip_name\"]", name = "scrip name")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_scrip_name\"]", name = "scrip name")
    public Element scripName;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_ltp\"]", name = "scrip price")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_ltp\"]", name = "scrip price")
    public Element scripPrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_change\"]", name = "scrip price trends")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "//*[@content-desc=\"scrip_details_change\"]", name = "scrip price trends")
    public Element scripPriceTrends;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Overview\"]", name = "overview")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "overview")
    public Element overview;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Chart\"]", name = "chart")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "chart")
    public Element chart;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Fundamentals\"]", name = "Fundamentals")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Fundamentals")
    public Element fundamentals;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Technicals\"]", name = "Technicals")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Technicals")
    public Element technicals;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Events\"]", name = "Events")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Events")
    public Element events;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"News\"]", name = "news")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "News")
    public Element news;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Related\"]", name = "Related")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Related")
    public Element related;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "scrip_details_exchange", name = "Exchange toggle")
    @PPiOSFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "scrip_details_exchange", name = "Exchange toggle")
    public Element exchangeToggle;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Volume(Abs.)']/preceding-sibling::android.view.ViewGroup[0]", name = "Line Chart 1 day")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 1 day")
    public Element lineChart1Day;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text='Volume(Abs.)']/preceding-sibling::android.view.ViewGroup[1]", name = "Line Chart 5 day")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 5 day")
    public Element lineChart5Day;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart 1 month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 1 month")
    public Element lineChart1Month;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart 3 month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 3 month")
    public Element lineChart3Month;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart Ytd")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart YTD")
    public Element lineChartYtd;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart 1 Y")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 1 Y")
    public Element lineChart1Y;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart 5 Y")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart 5 Y")
    public Element lineChart5Y;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart All")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart All")
    public Element lineChartAll;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/preceding-sibling::android.view.ViewGroup", name = "Line Chart")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "scrip_details_exchange", name = "Line Chart")
    public Element lineChart;


    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Open Price\"]/following-sibling::android.widget.TextView", name = "open price")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Open price")
    public Element openPrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Prev. Close\"]/following-sibling::android.widget.TextView", name = "Prev. Close")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Prev. Close")
    public Element prevClose;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Volume(Abs.)\"]/following-sibling::android.widget.TextView", name = "Volume")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Volume")
    public Element volume;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Avg Trade Price\"]/following-sibling::android.widget.TextView", name = "Avg Trade Price")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Avg Trade Price")
    public Element avgTradePrice;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Upper Circuit\"]/following-sibling::android.widget.TextView", name = "Upper Circuit")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Upper Circuit")
    public Element upperCircuit;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Lower Circuit\"]/android.widget.TextView", name = "Lower Circuit")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Lower Circuit")
    public Element lowerCircuit;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Today's Low\"]/preceding-sibling::android.widget.TextView[13]", name = "Today's low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Today's low")
    public Element todayLow;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Today's Low\"]/preceding-sibling::android.widget.TextView[14]", name = "Today's high")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Today's High")
    public Element todayHigh;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Market Depth\"]", name = "Market depth")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Market depth")
    public Element marketDepth;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Analyst Recommendations\"]", name = "Analyst Recommendations")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Analyst Recommendations")
    public Element analystRecommendations;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Past Performance\"]", name = "Past Performance")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Past Performance")
    public Element pastPerformance;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Market Depth\"]/following-sibling::android.widget.TextView[3]", name = "Market depth buy order percentage")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Market depth buy order percentage")
    public Element marketDepthBuyOrder;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Market Depth\"]/following-sibling::android.widget.TextView[4]", name = "Market depth sell order percentage")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Market depth sell order percentage")
    public Element marketDepthSellOrder;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Total\"])[1]/following-sibling::android.widget.TextView[1]", name = "Market depth:: Total buy")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Market depth:: Total buy")
    public Element marketDepthTotalBuy;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "(//android.widget.TextView[@text=\"Total\"])[2]/following-sibling::android.widget.TextView[1]", name = "Market depth:: Total sell")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Market depth:: Total sell")
    public Element marketDepthTotalSell;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"circle_info\"]/following-sibling::android.view.View[2]/android.widget.TextView[1]", name = "Analyst recommendations:: buy percentage")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Analyst recommendations:: buy percentage")
    public Element analystRecommendationsBuyPercentage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"circle_info\"]/following-sibling::android.view.View[2]/android.widget.TextView[2]", name = "Analyst recommendations:: Hold percentage")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Analyst recommendations:: hold percentage")
    public Element analystRecommendationsHoldPercentage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.ImageView[@content-desc=\"circle_info\"]/following-sibling::android.view.View[2]/android.widget.TextView[3]", name = "Analyst recommendations:: Sell percentage")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Analyst recommendations:: Sell percentage")
    public Element analystRecommendationsSellPercentage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Past Performance\"]/following-sibling::android.widget.TextView[1]", name = "Past performance:: 52 week low")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Past performance:: 52 week low")
    public Element pastPerformance52WeekLow;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Past Performance\"]/following-sibling::android.widget.TextView[2]", name = "Past performance:: 52 week high")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Past performance:: 52 week high")
    public Element pastPerformance52WeekHigh;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[9]", name = "Returns:: 1 week")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 1 week")
    public Element returns1Week;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[10]", name = "Returns:: 1 month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 1 month")
    public Element returns1Month;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[11]", name = "Returns:: 3 month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 3 month")
    public Element returns3Month;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[12]", name = "Returns:: 6 month")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 6 month")
    public Element returns6Month;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[13]", name = "Returns:: 1 Year")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 1 Year")
    public Element returns1Year;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[14]", name = "Returns:: 3 Year")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 3 Year")
    public Element returns3Year;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Returns\"]/following-sibling::android.widget.TextView[15]", name = "Returns:: 5 Year")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Returns:: 5 Year")
    public Element returns5Year;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@content-desc=\"Close\"]", name = "Back button")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "")
    public Element backButton;


    public ChartsPage goToChart(){
        chart.click();
        return new ChartsPage();
    }

    public FundamentalsPage goToFundamentals(){
        fundamentals.click();
        return new FundamentalsPage();
    }

    public TechnicalsPage goToTechnicals(){
        technicals.click();
        return new TechnicalsPage();
    }

    public EventsPage goToEvents(){
        events.click();
        return new EventsPage();
    }

    public NewsPage goToNews(){
        news.click();
        return new NewsPage();
    }

    public MarketPage backToHomePageFromScripDetails(){
        backButton.click();
        return new MarketPage();
    }

}

