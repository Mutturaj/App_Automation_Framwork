package com.stockBroking.qa.pages.scripDetails;

import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class FundamentalsPage extends BasePage {

    public FundamentalsPage(){
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()), this);
    }

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats::Market cap")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::Market cap")
    public Element marketCap;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats::EPS")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::EPS")
    public Element eps;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats::Book Value/Share")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::EPS")
    public Element bookValueShare;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats::P/E Ratio")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::P/E Ratio")
    public Element peRatio;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats:: Industry P/E ")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::Industry P/E ")
    public Element industryPe;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats:: P/B Ratio ")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::P/B Ratio ")
    public Element pbRatio;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats:: Long term D/E")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::Long term D/E")
    public Element longTermDe;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats:: ROE")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::ROE")
    public Element roe;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Key Stats:: Dividend yield")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Key Stats::Dividend yield")
    public Element dividendYield;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Income details:: view Details")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Income details:: view Details")
    public Element viewDetails;

    @PPAndroidFindBy(by= MobileByStrategy.XPATH, locator = "", name = "Income details:: income statement")
    @PPiOSFindBy(by = MobileByStrategy.XPATH, locator = "", name = "Income details:: income statement")
    public Element incomeStatement;
}
