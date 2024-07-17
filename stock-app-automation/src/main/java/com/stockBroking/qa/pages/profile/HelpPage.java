package com.stockBroking.qa.pages.profile;

import listner.ThreadCreator;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.elements.Element;
import pagefactory.elements.Elements;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

public class HelpPage extends BasePage {
    public HelpPage() {
        super(ThreadCreator.getLocalDriver());
        PageFactory.create(new PageFieldDesigner(ThreadCreator.getLocalDriver()), this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Help Center\"]/preceding-sibling::android.widget.Button", name = "Back button Help Page")
    public Element backButtonHelpPage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Support\"]/preceding-sibling::android.widget.Button", name = "Back button Support Page")
    public Element backButtonSupportPage;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"View Tickets\"]/following-sibling::android.widget.Button", name = "View Tickets")
    public Element viewTickets;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.Button[@text=\"Contact Support\"]", name = "Contact Support Button")
    public Element contactSupport;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Trading & Investment All you need to know about product and order types, corporate actions, ETFs, market timings, and basics of the stock market.", name = "Trading & Investment Topic")
    public Element tradingInvestmentTopic;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Getting Started Know how to open a demat and trading account.", name = "Getting Started Topic")
    public Element gettingStartedTopic;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Portfolio & Account Learn how to best manage your account, view your portfolio, access reports, and so on.", name = "Portfolio & Account Topic")
    public Element portfolioAccountTopic;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Brokerage and Regulatory Charges Get a detailed breakdown of all applicable charges – brokerage, regulatory fees, margin requirements, and so on.", name = "Brokerage and Regulatory Charges")
    public Element brokerageRegulatoryTopic;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Manage Your Funds Efficiently manage your funds by learning how to easily add & withdraw funds.", name = "Manage Your Funds Topic")
    public Element manageFundsTopic;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "WealthBasket Explore WealthBaskets and diversify your portfolio!", name = "WealthBasket Topic")
    public Element wealthBasketTopic;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@resource-id=\"gatsby-focus-wrapper\"]", name = "Getting Started Section")
    public Element gettingStartedSection;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@resource-id=\"gatsby-focus-wrapper\"]/android.widget.TextView[@text=\"Getting Started\"]", name = "Getting Started Section Heading")
    public Element gettingStartedSectionHeading;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@resource-id=\"gatsby-focus-wrapper\"]/android.view.View/android.view.View", name = "Getting Started Sub Topics")
    public Elements gettingStartedSubTopics;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "What is a demat and trading account?", name = "Account Opening First Question")
    public Element accountOpeningFirstQuestion;

    @PPAndroidFindBy(by = MobileByStrategy.ACCESSIBILITY, locator = "Account Opening", name = "Account Opening Sub Topic")
    public Element accountOpeningSubTopic;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Hello, what can I help you with today?\"]", name = "What Can i help Text")
    public Element whatCanIHelpText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.RadioButton[@text=\"Opening a trading and demat account\"]", name = "Opening a trading and Demat account")
    public Element openingTradeDematBotQuestion;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.Button[@resource-id=\"PREVIOUS\"]", name = "Go Back Button")
    public Element goBackButton;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Do you need more help with this?\"]", name = "need more help text")
    public Element needMoreHelpText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.widget.TextView[@text=\"Thank you.\"]", name = "Thank you text")
    public Element thankYouText;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@text=\"Email\"]", name = "Email Suggestion")
    public Element emailBotSuggestion;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@text=\"Unable to use email\"]", name = "Unable to use a Email Suggestion")
    public Element unableToUseEmailSuggestion;

    @PPAndroidFindBy(by = MobileByStrategy.XPATH, locator = "//android.view.View[@text=\"No\"]", name = "No Bot Suggestion")
    public Element noBotSuggestion;
}
