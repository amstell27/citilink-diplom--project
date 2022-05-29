package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductCategoryPage {

    private final SelenideElement
            checkCategory = $(AppiumBy.id("ru.citilink:id/textViewCustomTitle"));

    public ProductCategoryPage checkCategory(String category) {
        checkCategory.shouldHave(text(category));
        return this;
    }
}
