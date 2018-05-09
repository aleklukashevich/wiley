package selenium;

import pages.*;

/**
 * Created by Alek on 08.05.2018.
 */
public class PageProvider {

    public HomePage getHomePage(String url){
        Browser.getDriver().get(url);
        return new HomePage();
    }

    public ElectricalEngineeringPage getElectricalEngineeringPage(){
        return new ElectricalEngineeringPage();
    }

    public SearchResultPage getSearchResultsPage(){
        return new SearchResultPage();
    }

    public ExtendedSearchPage getExtendedSearchPage(){
        return new ExtendedSearchPage();
    }

    public FavouritesPage getFavouritesPage(){
        return new FavouritesPage();
    }
}
