package com.stockBroking.qa.testRail;

public enum TestRunType {
    BETA("1"),
    RC("2");

    public final String testRun;

    TestRunType(String testRun){
        this.testRun = testRun;
}
}