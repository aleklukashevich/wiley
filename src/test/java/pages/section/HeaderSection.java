package pages.section;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by Aleksandr on 25.08.2016.
 */
public class HeaderSection extends BasePage {

    @FindBy(xpath = "//div[@id='links-site']//a[contains(text(),'Home')]")private WebElement homeLink;

    public void returnToHome(){
        homeLink.click();
    }
}
