package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductSearchPage {
    private final SelenideElement
            checkProductSearch = $(AppiumBy.id("ru.citilink:id/textViewProductsListTitle")),
            addToCart = $(AppiumBy.id("ru.citilink:id/buttonProductAddToCart")),
            openTheCart = $(AppiumBy.id("ru.citilink:id/ordering_graph"));

    public ProductSearchPage checkSearch(String value) {
        checkProductSearch.shouldHave(text(value));
        return this;
    }

    public ProductSearchPage addToCart() {
        addToCart.click();
        return this;
    }

    public ProductSearchPage openTheCart() {
        openTheCart.click();
        return this;
    }

}
