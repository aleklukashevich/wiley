package pages;

import org.openqa.selenium.By;
import test.tmp.Base;

/**
 * Created by Alek on 08.05.2018.
 */
public class HomePage extends BasePage {
    private static final By CHANGE_LANG_LINK = By.cssSelector(".menu_lang .a_menu");
    private static final By ELECTRIC_CATEGORY_LOCATOR = By.cssSelector(".a1[href='/ru/electronics/']");

    public HomePage clickChangeLanguageLink(Language lang) {
        int repeats = 0;
        do{
            element(CHANGE_LANG_LINK).click();
            repeats++;
        } while ( repeats == 5 || element(CHANGE_LANG_LINK).getText().equals(lang.getLanguage()));

        return this;
    }

    public HomePage clickElectricalEngineeringLink() {
        element(ELECTRIC_CATEGORY_LOCATOR).click();
        return this;
    }

    public enum Language {
        RU("RU"),
        LV("LV");
        private String language;

        Language(String language) {
            this.language = language;
        }

        public String getLanguage() {
            return this.language;
        }
    }

}
