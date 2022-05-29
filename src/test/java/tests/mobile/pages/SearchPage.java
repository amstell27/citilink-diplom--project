package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement
            setProductSearch = $(AppiumBy.id("ru.citilink:id/editTextSearchToolbar")),
            clickCategory = $(AppiumBy.id("ru.citilink:id/recyclerViewSuggestedCategories")),
            choiceProduct = $(AppiumBy.id("ru.citilink:id/textViewSearchProductName"));

    public SearchPage inputNameSearch(String value) {
        setProductSearch.setValue(value);
        return this;
    }

    public SearchPage clickFoundCategory() {
        clickCategory.click();
        return this;
    }

    public SearchPage choiceProduct() {
        choiceProduct.click();
        return this;
    }
}
