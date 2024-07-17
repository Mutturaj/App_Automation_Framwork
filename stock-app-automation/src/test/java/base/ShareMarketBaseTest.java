package base;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pagefactory.BaseTest;

public class ShareMarketBaseTest extends BaseTest {

    public AppiumDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        if (env.isAndroid())
            executor.setAndroidCustomExtensions(env, "", "", "");
        else
            executor.setIosCustomExtensions(env, "", "", "");
        executor.beforeSuiteCompulsory(context, env);
        executor.beforeSuiteOptional(context);
    }
}
