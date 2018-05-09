package section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Browser;

/**
 * Created by Alek on 09.05.2018.
 */
public class SearchResultRow {
    private final WebElement element;
    private final String title;
    private final String price;
    private final boolean isSelected;
    private final String id;

    public SearchResultRow(WebElement element){
        this.element = element;
        this.title = element.findElement(By.cssSelector("[id*='dm_']")).getText();
        this.price = element.findElement(By.xpath(".//*[contains(text(), '€')]")).getText();
        this.isSelected = element.findElement(By.cssSelector("input")).isSelected();
        this.id = element.getAttribute("id").split("_")[1];
    }

    public String getId(){
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPrice() {
        return this.price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchResultRow that = (SearchResultRow) o;

        if (isSelected != that.isSelected) return false;
        if (element != null ? !element.equals(that.element) : that.element != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        int result = element != null ? element.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isSelected ? 1 : 0);
        return result;
    }
}
