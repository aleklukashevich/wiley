package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Browser;
import selenium.ElementFinder;

import java.util.concurrent.TimeUnit;

public abstract class BasePage extends ElementFinder {
    private WebDriverWait wait;

    BasePage() {
        driver = Browser.getDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
    }

    void waitForLoad() {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    protected WebDriverWait getWaitDriver(){
        return wait;
    }
}
