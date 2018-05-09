package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Alek on 09.05.2018.
 */
public class ExtendedSearchPage extends BasePage {
    private static final By SEARCH_FIELD_LOCATOR = By.cssSelector("#ptxt");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("[name='btn']");
    private static final By DROP_DOWN_OPTIONS_LOCATOR = By.cssSelector("[id*=cmp_]");
    private static final By DROP_DOWN_MAIN_LOCATOR = By.cssSelector("#preload_txt");
    //Search params options
    private static final By SUB_CATEGORY_LOCATOR = By.cssSelector("[name='sid']");
    private static final By SEARCH_REGION_LOCATOR = By.cssSelector("[name='search_region']");
    private static final By PERIOD_LOCATOR = By.cssSelector("[name='pr']");
    private static final By SORT_BY_LOCATOR = By.cssSelector("[name='sort']");
    private static final By MIN_PRICE_LOCATOR = By.cssSelector("[name='topt[8][min]']");
    private static final By MAX_PRICE_LOCATOR = By.cssSelector("[name='topt[8][max]']");

    public ExtendedSearchPage inputSearchQuery(String query) {
        element(SEARCH_FIELD_LOCATOR).sendKeys(query);

        getWaitDriver().until(ExpectedConditions.visibilityOf(element(DROP_DOWN_MAIN_LOCATOR)));

        elements(DROP_DOWN_OPTIONS_LOCATOR).stream()
                .filter(element -> element.getText().equals(query))
                .findFirst().get().click();
        return this;
    }

    public ExtendedSearchPage selectSubCategoryOption(int option){
        getSubCategorySelect().selectByIndex(option);
        return this;
    }

    public ExtendedSearchPage selectSearchRegionOption(int option){
        getSearchRegionSelect().selectByIndex(option);
        return this;
    }

    public ExtendedSearchPage selectPeriodOption(int option){
        getPeriodSelect().selectByIndex(option);
        return this;
    }

    public ExtendedSearchPage selectSortByOption(int option){
        getSortBySelect().selectByIndex(option);
        return this;
    }

    public ExtendedSearchPage clickSearchButton() {
        element(SEARCH_BUTTON_LOCATOR).click();
        return this;
    }

    public ExtendedSearchPage setPriceFrom(int from){
        element(MIN_PRICE_LOCATOR).sendKeys(String.valueOf(from));
        return this;
    }

    public ExtendedSearchPage setPriceTo(int to){
        element(MAX_PRICE_LOCATOR).sendKeys(String.valueOf(to));
        return this;
    }

    private Select getSubCategorySelect() {
        return new Select(element(SUB_CATEGORY_LOCATOR));
    }

    private Select getSearchRegionSelect() {
        return new Select(element(SEARCH_REGION_LOCATOR));
    }

    private Select getPeriodSelect() {
        return new Select(element(PERIOD_LOCATOR));
    }

    private Select getSortBySelect() {
        return new Select(element(SORT_BY_LOCATOR));
    }


}
