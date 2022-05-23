package tests.mobile;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBaseMobile {
    @Test
    void setAndCheckRegion() {
        sleep(200);
        step("Skip onboarding", Selenide::back);
        step("Set the city", () -> {
            $(AppiumBy.id("ru.citilink:id/profile_graph")).click();
            $(AppiumBy.id("ru.citilink:id/contentProfileCityRow")).click();
            $(AppiumBy.id("ru.citilink:id/searchMenu")).click();
            $(AppiumBy.id("ru.citilink:id/search_src_text")).setValue("Казань");
            $(AppiumBy.id("ru.citilink:id/textViewCityName")).click();

        });

        step("Verify content found", () -> {
            $(AppiumBy.id("ru.citilink:id/textViewProfileCityValue")).shouldHave(text("Казань"));
        });
    }

    @Test
    void searchTest() {
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("Set the search", () -> {
            $(AppiumBy.id("ru.citilink:id/buttonSearch")).click();
            $(AppiumBy.id("ru.citilink:id/editTextSearchToolbar")).setValue("Модули памяти");
            $(AppiumBy.id("ru.citilink:id/recyclerViewSuggestedCategories")).click();

        });

        step("Verify content found", () -> {
            $(AppiumBy.id("ru.citilink:id/textViewProductsListTitle")).shouldHave(text("Модули памяти"));
        });
    }

    @Test
    void catalogTest() {
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("Set the Catalog", () -> {
            $(AppiumBy.accessibilityId("Каталог")).click();
            $(AppiumBy.id("ru.citilink:id/recyclerViewMainCategories"))
                    .$(AppiumBy.id("ru.citilink:id/textViewMainCategoryTitle"))
                    .shouldHave(text("Смартфоны и гаджеты")).click();
        });

        step("Verify content found", () -> {
            $(AppiumBy.id("ru.citilink:id/textViewCustomTitle")).shouldHave(text("Смартфоны и гаджеты"));
        });
    }

    @Test
    void addToBasketTest() {
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("add product to basket", () -> {
            $(AppiumBy.id("ru.citilink:id/buttonSearch")).click();
            $(AppiumBy.id("ru.citilink:id/editTextSearchToolbar")).setValue("Смартфон Xiaomi 11");
            $(AppiumBy.id("ru.citilink:id/textViewSearchProductName"))
                    .click();
            $(AppiumBy.id("ru.citilink:id/buttonProductAddToCart")).click();
//            sleep(2000);
        });

        step("Verify to add product", () -> {
            $(AppiumBy.id("ru.citilink:id/ordering_graph")).click();
            $(AppiumBy.id("ru.citilink:id/constraintLayoutCartProduct"))
                    .$(AppiumBy.id("ru.citilink:id/textViewCartProductName"))
                    .shouldHave(text("Смартфон Xiaomi"));
        });
    }


}
