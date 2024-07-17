package com.stockBroking.qa.testRail;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Arrays;

public class TestRailListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        TestRail testRailId =
                method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(TestRail.class);
        if (testRailId == null) {
            return;
        }
        if (method.getTestMethod().isDataDriven()) {
            Object[] parameters = testResult.getParameters();
            if (testResult.getThrowable() instanceof SkipException) {
                testResult.setStatus(ITestResult.SKIP);
            }
            // Post the result to Test Rail
            try {
                new TestRailConfig().postTestRailResult(testRailId.testRailId(), testResult, Arrays.toString(parameters));
            } catch (APIException | IOException e) {
                throw new RuntimeException(e);
            }
            //new TestRailConfig().addTestRailResultMap(testRailId.testRailId(), testResult, Arrays.toString(parameters));
        } else {
            try {
                new TestRailConfig().postTestRailResult(testRailId.testRailId(), testResult);
            } catch (APIException | IOException e) {
                throw new RuntimeException(e);
            }
            //new TestRailConfig().addTestRailResultMap(testRailId.testRailId(), testResult);
    }
}
}