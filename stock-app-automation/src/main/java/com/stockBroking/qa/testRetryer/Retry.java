package com.stockBroking.qa.testRetryer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        int maxRetryCount = 1;
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + iTestResult.getName() + " with status "
                    + getResultStatusName(iTestResult.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if(status==1)
            resultName = "SUCCESS";
        if(status==2)
            resultName = "FAILURE";
        if(status==3)
            resultName = "SKIP";
        return resultName;
}
}