package com.stockBroking.qa.pages.ipo;

import org.openqa.selenium.WebDriver;
import pagefactory.BasePage;
import pagefactory.PageFactory;
import pagefactory.annotations.PPAndroidFindBy;
import pagefactory.annotations.PPiOSFindBy;
import pagefactory.elements.Element;
import pagefactory.proxy.MobileByStrategy;
import pagefactory.proxy.PageFieldDesigner;

import static listner.ThreadCreator.getLocalDriver;

public class BiddingForm extends BasePage {

    public BiddingForm() {
        super(getLocalDriver());
        PageFactory.create(new PageFieldDesigner(getLocalDriver()),this);
    }

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Price type")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Price type")
    public Element priceType;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Custom Price")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Custom Price")
    public Element customPrice;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "cut-off price")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "cut-off price")
    public Element cutOffPrice;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "bid price")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "bid price")
    public Element bidPrice;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "add lot")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "add lot")
    public Element addLot;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "delete lot")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "delete lot")
    public Element deleteLot;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Bid 2")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Bid 2")
    public Element bid2Toggle;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Bid 3")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Bid 3")
    public Element bid3Toggle;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Amount payable")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Amount payable")
    public Element amountPayable;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "apply")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "apply")
    public Element apply;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "show details")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "show details")
    public Element showDetails;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "enter your upi id")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "enter your upi id")
    public Element enterUpiId;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "proceed to pay")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "proceed to pay")
    public Element proceedToPay;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "proceed To Pay Confirm Your Details")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "proceed To Pay Confirm Your Details")
    public Element proceedToPayConfirmYourDetails;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "UPI ID Pay Confirm Your Details")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "UPI ID Pay Confirm Your Details")
    public Element upiIdConfirmYourDetails;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "account Name Confirm Your Details")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "account Name Confirm Your Details")
    public Element accountTypeConfirmYourDetails;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "change upi id")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "change upi id")
    public Element changeUpiId;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "did not get the upi request")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "did not get the upi request")
    public Element didNotGetTheUpiRequest;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Modify")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "Modify")
    public Element modify;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "cancel")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "cancel")
    public Element cancel;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "done")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "done")
    public Element done;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "Open PhonePe")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "open PhonePe")
    public Element openPhonePe;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "view bid details")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "view bid details")
    public Element viewBidDetails;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "upi id application status")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "upi id application status")
    public Element upiIdApplicationStatus;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "amount application status")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "amount application status")
    public Element amountApplicationStatus;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "order timeline")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "order timeline")
    public Element orderTimeline;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "switch to HNI")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "switch to HNI")
    public Element switchToHNI;

    @PPAndroidFindBy(by = MobileByStrategy.ID, locator = "",name = "do not switch to HNI")
    @PPiOSFindBy(by = MobileByStrategy.ID, locator = "",name = "do not switch to HNI")
    public Element doNotSwitchToHNI;



}
