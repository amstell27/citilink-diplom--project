package tests.mobile.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class MobilePages {


    public MobilePages setRegion(String region) {

        $(AppiumBy.id("ru.citilink:id/profile_graph")).click();
        $(AppiumBy.id("ru.citilink:id/contentProfileCityRow")).click();
        $(AppiumBy.id("ru.citilink:id/searchMenu")).click();
        $(AppiumBy.id("ru.citilink:id/search_src_text")).setValue(region);
        $(AppiumBy.id("ru.citilink:id/textViewCityName")).click();
        return this;
    }

    public MobilePages checkRegion(String region) {
        $(AppiumBy.id("ru.citilink:id/textViewProfileCityValue")).shouldHave(text(region));
        return this;
    }

    public MobilePages inputNameSearch(String value) {
        $(AppiumBy.id("ru.citilink:id/buttonSearch")).click();
        $(AppiumBy.id("ru.citilink:id/editTextSearchToolbar")).setValue(value);
        return this;
    }

    public MobilePages clickFoundCategory() {
        $(AppiumBy.id("ru.citilink:id/recyclerViewSuggestedCategories")).click();
        return this;
    }

    public MobilePages checkSearch(String value) {
        $(AppiumBy.id("ru.citilink:id/textViewProductsListTitle")).shouldHave(text(value));
        return this;
    }

    public MobilePages openCatalog() {
        $(AppiumBy.accessibilityId("Каталог")).click();
        return this;
    }

    public MobilePages setCategory(String category) {
        $(AppiumBy.id("ru.citilink:id/recyclerViewMainCategories"))
                .$(AppiumBy.id("ru.citilink:id/cardViewMainCategoryItem"))
                .$(AppiumBy.id("ru.citilink:id/textViewMainCategoryTitle"))
                .shouldHave(text(category)).click();
        return this;
    }

    public MobilePages checkCategory(String category) {
        $(AppiumBy.id("ru.citilink:id/textViewCustomTitle")).shouldHave(text(category));
        return this;
    }

    public MobilePages choiceProduct() {
        $(AppiumBy.id("ru.citilink:id/textViewSearchProductName")).click();
        return this;
    }

    public MobilePages addToCart() {
        $(AppiumBy.id("ru.citilink:id/buttonProductAddToCart")).click();
        return this;
    }

    public MobilePages openTheCart() {
        $(AppiumBy.id("ru.citilink:id/ordering_graph")).click();
        return this;
    }

    public MobilePages checkToAddProduct(String product) {
        $(AppiumBy.id("ru.citilink:id/constraintLayoutCartProduct"))
                .$(AppiumBy.id("ru.citilink:id/textViewCartProductName"))
                .shouldHave(text(product));
        return this;
    }


}

