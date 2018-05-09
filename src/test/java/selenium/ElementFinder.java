package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Alek on 08.05.2018.
 */
public class ElementFinder {
    protected WebDriver driver;

    public WebElement element(By locator){
        try {
            return driver.findElement(locator);
        }catch (StaleElementReferenceException ex){
            return driver.findElement(locator);
        }catch (NoSuchElementException e){
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(locator));
            return driver.findElement(locator);
        }
    }

    public List<WebElement> elements(By locator){
        try {
            return driver.findElements(locator);
        }catch (StaleElementReferenceException ex){
            return driver.findElements(locator);
        }
    }
}
