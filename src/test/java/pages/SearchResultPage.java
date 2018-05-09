package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import section.SearchResultRow;
import selenium.ParamHolder;

import java.util.List;
import java.util.stream.Collectors;

import static util.Constants.SELECTED_LIST;
import static util.RandomUtil.coin;

/**
 * Created by Alek on 09.05.2018.
 */
public class SearchResultPage extends BasePage {
    private static final By SEARCH_RESULTS_LOCATOR = By.cssSelector("[id*=tr_]:not([style*='display:none'])");
    private static final By EXTENDED_SEARCH_LINK_LOCATOR = By.cssSelector("[href='/ru/electronics/search/']");
    private static final By PRICE_SORT_OPTION_LOCATOR = By.cssSelector("noindex a[title='']");
    private static final By SUB_CATEGORY_OPTION_LOCATOR = By.cssSelector("[name='sid']");
    private static final By ADD_TO_MEMO_LOCATOR = By.cssSelector("#a_fav_sel");
    private static final By ALERT_OK_BUTTON = By.cssSelector("#alert_dv #alert_ok");
    private static final By FAVOURITES_LINK_LOCATOR = By.cssSelector("[href='/ru/favorites/']");

    public SearchResultPage selectRandomResults() {
        waitForLoad();
        getSearchResultList().forEach(element -> {
            if (coin()) {
                element.findElement(By.cssSelector("[name=mid\\[\\]]")).click();
            }
        });

        List<SearchResultRow> results = getSearchResultList().stream()
                .map(SearchResultRow::new)
                .collect(Collectors.toList());

        List<SearchResultRow> selectedRowsList = results.stream()
                .filter(SearchResultRow::isSelected)
                .collect(Collectors.toList());

        ParamHolder.setParam(SELECTED_LIST, selectedRowsList);

        return this;
    }

    public SearchResultPage clickAddToMemo() {
        element(ADD_TO_MEMO_LOCATOR).click();
        return this;
    }

    public SearchResultPage clickExtendedSearch() {
        element(EXTENDED_SEARCH_LINK_LOCATOR).click();
        return this;
    }

    public SearchResultPage clickSortByPrice() {
        element(PRICE_SORT_OPTION_LOCATOR).click();
        return this;
    }

    public SearchResultPage selectSubCategoryByValue(String value) {
        new Select(element(SUB_CATEGORY_OPTION_LOCATOR)).selectByVisibleText(value);
        return this;
    }

    public SearchResultPage closeAlertNotificationIfPresent() {
        if (element(ALERT_OK_BUTTON).isEnabled()) {
            element(ALERT_OK_BUTTON).click();
        }
        return this;
    }

    public SearchResultPage clickFavouritesLink() {
        waitForLoad();
        try {
            element(FAVOURITES_LINK_LOCATOR).click();
        } catch (ElementClickInterceptedException ex) {
            element(FAVOURITES_LINK_LOCATOR).click();
        }
        return this;
    }

    private List<WebElement> getSearchResultList() {
        return elements(SEARCH_RESULTS_LOCATOR);
    }

}
