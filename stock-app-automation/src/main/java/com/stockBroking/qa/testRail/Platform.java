package com.stockBroking.qa.testRail;

public enum Platform {
    ANDROID("1"),
    iOS("2"),
    BOTH("3");

    public final String platform;

    Platform(String platform) {
        this.platform = platform;
}
}