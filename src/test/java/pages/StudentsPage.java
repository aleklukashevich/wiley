package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 24.08.2016.
 */
public class StudentsPage extends BasePage {
    @FindBy(id = "page-title") private WebElement header;
    //In task 8 items but on the page 7
    @FindBy(xpath = "//ul[@class='autonavLevel1']/li/*[1]")private List<WebElement> leftSideLinks;

    @FindBy(xpath="//ul[@class='autonavLevel1']//span")private WebElement selectedItem;

    @FindBy(xpath = "//*[@class='autonavLevel1']//li[contains(@class,'active')]")private WebElement studentsLnk;

    @FindBy(xpath = "//*[@class='autonavLevel1']/li[not(contains(@class,'active'))]")private List<WebElement> notActiveLinks;

    @FindBy(xpath = "//*[@class='autonavLevel1']//li[contains(@class,'active')]/span")private WebElement studentSpan;

    public String getHeader(){
         return header.getText();
    }

    public int getLeftSideLinksCount(){
        return leftSideLinks.size();
    }

    public List<String> getLeftSideLinks(){
        List<String> out = new ArrayList<String>();
        for (WebElement link: leftSideLinks){
            out.add(link.getText());
        }
        return out;
    }

    public boolean isStudentsSelected(){
        return studentsLnk.getAttribute("class").contains("active");
    }

    public boolean isStudentHasDifStyle(){
        return notActiveLinks.size() != leftSideLinks.size();
    }

    public boolean isClickable(){
        boolean yes = false;
        if(studentSpan.getAttribute("href") == null){
            yes = true;
        }
        return yes;
    }
}
