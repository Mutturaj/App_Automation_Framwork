package com.stockBroking.qa.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDP {

    @DataProvider(name = "mobilePage")
    public Object[][] getMobile() {
        return new Object[][]{
                {"1234567899", "8904423701", "Please enter a valid phone number"}
        };
    }

    @DataProvider(name = "testOtpScreen")
    public Object[][] testOtpScreen() {
        return new Object[][]{
                {"8448934879"}
        };
    }

    @DataProvider(name = "loginWithPhonePe")
    public Object[][] loginWithPhonePe() {
        return new Object[][]{
                {"8448934879", "8448"}
        };
/*        return new Object[][]{
                {"7354989876", "8448"}
        };*/
    }

    @DataProvider(name = "resendOtp")
    public Object[][] resendOtp() {
        return new Object[][]{
                {"7406821194"}
        };
    }

    @DataProvider(name = "wrongOtpTest")
    public Object[][] wrongOtpTest() {
        return new Object[][]{
                {"7897144642", "12345"}
        };
    }

    @DataProvider(name = "closeOtpScreen")
    public Object[][] closeOtpScreen() {
        return new Object[][]{
                {"9554498050", "12345"}
        };
    }

    //zaccountBlocked
    @DataProvider(name = "zaccountBlocked")
    public Object[][] zaccountBlocked() {
        return new Object[][]{
                {"8448934879", "12345"}
        };
    }

    @DataProvider(name = "testResetPassword")
    public Object[][] testResetPassword() {
        return new Object[][]{
                //String mobileNumber, String pin, String pan, String dob, String otp
                {"8448934879", "8448", "ALLPY0116A", "4 August 1990", ""},
                {"8448934879", "8448", "ALVPY0216G", "8 October 2023", ""},
                {"8448934879", "8448", "ALVPY0216G", "4 August 1990", "12345"},

        };
/*        return new Object[][]{
                {"7354989876", "8448"}
        };*/
    }
}
