package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksandr on 25.08.2016.
 */
public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[@class='productDetail-title']")private WebElement productTitle;

    public String getProductTitle(){
        waitForLoad();
        return productTitle.getText();
    }
}
