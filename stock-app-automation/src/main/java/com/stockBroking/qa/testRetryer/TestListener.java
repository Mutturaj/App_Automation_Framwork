package com.stockBroking.qa.testRetryer;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Set;

public class TestListener implements ITestListener {


    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getSkippedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 0) {
                failedTests.remove(temp);
            } else {
                if (context.getSkippedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
}
}