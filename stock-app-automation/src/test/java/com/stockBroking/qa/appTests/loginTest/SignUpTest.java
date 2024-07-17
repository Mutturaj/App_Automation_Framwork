package com.stockBroking.qa.appTests.loginTest;

import com.stockBroking.qa.dataprovider.LoginDP;
import io.qameta.allure.*;
import listner.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.stockBroking.qa.pages.login.LoginPage;
import com.stockBroking.qa.utils.TestUtils;

@Listeners(TestListener.class)
@Feature("Sign up Test")
public class SignUpTest {

    private TestUtils testUtils;
    private LoginPage loginPage;

    public SignUpTest(){
        testUtils = new TestUtils();
        loginPage = new LoginPage();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Sign up for new user with PhonePe")
    @Story("Sign up for new user with PhonePe")
    @Test(description = "User sign up", dataProvider = "signUp", dataProviderClass = LoginDP.class)
    void signUpTest(){

    }
}
