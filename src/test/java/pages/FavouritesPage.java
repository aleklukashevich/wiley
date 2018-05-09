package pages;

import org.openqa.selenium.By;
import section.SearchResultRow;
import selenium.ParamHolder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static util.Constants.SELECTED_LIST;

/**
 * Created by Alek on 09.05.2018.
 */
public class FavouritesPage extends BasePage {
    private static final By ADDED_ITEM_ROW = By.cssSelector("[id*=tr_]:not([style*='display:none'])");

    public FavouritesPage checkItemsAreTheSameAsAdded() {
        List<SearchResultRow> addedItems = elements(ADDED_ITEM_ROW).stream()
                .map(SearchResultRow::new)
                .collect(Collectors.toList());

        ArrayList<SearchResultRow> expected = ((ArrayList) ParamHolder.getParam(SELECTED_LIST));

        addedItems.sort(Comparator.comparing(SearchResultRow::getTitle));
        expected.sort(Comparator.comparing(SearchResultRow::getTitle));

        assertEquals(addedItems.size(), expected.size());

        IntStream.range(0, addedItems.size()).forEach(i -> {
            assertEquals(addedItems.get(i).getId(), expected.get(i).getId());
            assertEquals(addedItems.get(i).getTitle(), expected.get(i).getTitle());
            assertEquals(addedItems.get(i).getPrice(), expected.get(i).getPrice());
        });
        return this;
    }
}
