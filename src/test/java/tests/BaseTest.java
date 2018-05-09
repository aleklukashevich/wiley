package tests;

import listeners.DriverCloseListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.Browser;

@Listeners({
        DriverCloseListener.class
})
public abstract class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void init() {
        driver = Browser.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public abstract void run();

}
