package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * Created by Aleksandr on 24.08.2016.
 */
public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//div[@id='search-results']/div")private List<WebElement> booksList;
    private String title;

    public int checkBooksList(){
        return booksList.size();
    }

    public void selectRandomItem(){
        WebElement randomItem = booksList.get(new Random().nextInt(booksList.size()));
        WebElement title =  randomItem.findElement(By.xpath("//div[@class='product-title']/a"));
        this.title = title.getText();
        title.click();
    }

    public String getTitle(){
        return title;
    }
}
