package tests.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement

            checkFormSearch = $("[class='Subcategory__title-container']");

    public SearchPage checkSearch(String value) {
        checkFormSearch.shouldHave(text(value));
        return this;
    }

}
