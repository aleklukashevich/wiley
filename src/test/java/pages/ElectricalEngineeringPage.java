package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static util.RandomUtil.getRandomByNumber;

/**
 * Created by Alek on 08.05.2018.
 */
public class ElectricalEngineeringPage extends BasePage {
    private static final By SEARCH_LINK_LOCATOR = By.cssSelector("a[href='/ru/electronics/search/']");


    public ElectricalEngineeringPage clickSearchLink() {
        element(SEARCH_LINK_LOCATOR).click();
        return this;
    }


}
