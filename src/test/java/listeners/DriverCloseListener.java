package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import selenium.Browser;

/**
 * Created by Alek on 08.05.2018.
 */
public class DriverCloseListener implements ITestListener{
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        WebDriver webDriver = Browser.getDriver();
        if (webDriver != null) {
            try {
                webDriver.quit();
            } catch (Exception ignored) {
            } finally {
                Browser.setDriver(null);
            }
        }
    }
}
