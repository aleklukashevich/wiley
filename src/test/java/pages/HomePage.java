package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath="//div[@id='links-site']//a") private List<WebElement> navLinks;
    @FindBy(xpath = "//div[@id='homepage-links']//a") private List<WebElement> resLinks;
    @FindBy(xpath = "//div[@id='homepage-links']//a[contains(text(),'Students')]") private WebElement studentLnk;
    @FindBy(id="EmailAddress")private WebElement emailFld;
    @FindBy(id = "id31")private WebElement sbscrBtn;
    @FindBy(id="query")private WebElement queryFld;
    @FindBy(xpath = "//input[contains(@class,'icon icon__search')]")private WebElement searchIcon;
    @FindBy(xpath = "//div[@id='homepage-links']//a[contains(text(),'Institutions')]") private WebElement instLink;


    public List<String> getNavLinks(){
       List<String> navMenu = new ArrayList<String>();
            for (WebElement link : navLinks) {
                navMenu.add(link.getText());
            }
       return navMenu;
    }

    public List<String> getResLinks(){
        List<String> out = new ArrayList<String>();
        for (WebElement link : resLinks) {
            out.add(link.getText());
        }
        return out;
    }

    public void navigateToStudents(){
        studentLnk.click();
    }

    public void applySubcsr(String email){
        emailFld.clear();
        if(email != null) {
            emailFld.sendKeys(email);
        }
        sbscrBtn.click();
    }

    public String validateAlert(){
        return driver.switchTo().alert().getText();
    }

    public void performSearch(String query){
        queryFld.clear();
        queryFld.sendKeys(query);
        searchIcon.click();
    }

    public String clickInst(){
        instLink.click();
        driver.switchTo().window(driver.getWindowHandle()).close();
        //switch to new window
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().defaultContent();
        waitForLoad();
        return driver.getCurrentUrl();
    }



}
