package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPage {

    private final SelenideElement
            setCategory = $(AppiumBy.id("ru.citilink:id/recyclerViewMainCategories"))
            .$(AppiumBy.id("ru.citilink:id/cardViewMainCategoryItem"))
            .$(AppiumBy.id("ru.citilink:id/textViewMainCategoryTitle"));

    public CategoryPage setCategory(String category) {
        setCategory.shouldHave(text(category)).click();
        return this;
    }
}
