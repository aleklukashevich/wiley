package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "./src/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }
}
