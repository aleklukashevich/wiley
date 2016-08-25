package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.Browser;

public abstract class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void init(){
       driver = Browser.getDriver();
       driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @Test
    public abstract void run();

    @AfterClass
    public void tearDown(){
        softAssert.assertAll();
        Browser.close(); }

}
