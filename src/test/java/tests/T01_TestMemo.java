package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import selenium.PageProvider;

public class T01_TestMemo extends BaseTest {
    private String site;
    private final PageProvider provider = new PageProvider();
    //I've chosen this way because randomizing is not great, because some options may produce No Search Result notification
    private final int OPTION_INDEX = 1;
    private static final String SUB_CATEGORY = "Продажа";

    @BeforeMethod
    @Parameters({"site"})
    public void setParameters(String site) {
        this.site = site;
    }

    public void run() {
        //Step 1 - 3
        navigateToElectricalEngineeringCategory();
        //Step 4 - 5
        navigateToSearchPage();
        searchByKeyWord("Компьютер");
        //Step 6-7
        sortResultAndNavigateToExtendedSearch();
        //Step 8
        setPriceRangeAndClickSearch(0,300);
        //Step 9 - 10
        selectRandomFilesAndAddToMemo();
        //Step 11-12
        //Fails in check because titles are different, seems like ui issue or so also ids seems different either 
        navigateToFavouritePageAndCheckItems();
    }

    private void navigateToElectricalEngineeringCategory() {
        provider.getHomePage(site)
                .clickChangeLanguageLink(HomePage.Language.RU)
                .clickElectricalEngineeringLink();
    }

    private void navigateToSearchPage() {
        provider.getElectricalEngineeringPage()
                .clickSearchLink();
    }

    private void searchByKeyWord(String query) {
        provider.getExtendedSearchPage()
                .inputSearchQuery(query)
                .selectPeriodOption(OPTION_INDEX)
                .selectSearchRegionOption(OPTION_INDEX)
                .selectSortByOption(OPTION_INDEX)
                .selectSubCategoryOption(OPTION_INDEX)
                .clickSearchButton();
    }

    private void sortResultAndNavigateToExtendedSearch(){
        provider.getSearchResultsPage()
                .clickSortByPrice()
                .selectSubCategoryByValue(SUB_CATEGORY)
                .clickExtendedSearch();
    }

    private void setPriceRangeAndClickSearch(int from, int to){
        provider.getExtendedSearchPage()
                .setPriceFrom(from)
                .setPriceTo(to)
                .clickSearchButton();
    }

    private void selectRandomFilesAndAddToMemo(){
        provider.getSearchResultsPage()
                .selectRandomResults()
                .clickAddToMemo()
                .closeAlertNotificationIfPresent();
    }

    private void navigateToFavouritePageAndCheckItems(){
        provider.getSearchResultsPage()
                .clickFavouritesLink();
        provider.getFavouritesPage()
                .checkItemsAreTheSameAsAdded();
    }
}
