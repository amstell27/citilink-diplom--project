package tests.mobile;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.mobile.pages.MobilePages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
public class AndroidSelenideTests extends TestBaseMobile {

    MobilePages mobilePage = new MobilePages();

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург", "Саров"})
    @ParameterizedTest(name = "\"{0}\"")
    void setAndCheckRegion(String region) {

        sleep(200);
        step("Skip onboarding", Selenide::back);
        step("Set the city", () -> {
            mobilePage.setRegion(region);
        });
        step("Verify choice region", () -> {
            mobilePage.checkRegion(region);
        });
    }

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Модули памяти", "Процессоры"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {
        sleep(200);
        step("Skip onboarding", Selenide::back);
        step("Set the search", () -> {
            mobilePage.inputNameSearch(value);
            mobilePage.clickFoundCategory();
        });
        step("Verify content found", () -> {
            mobilePage.checkSearch(value);
        });
    }

    @Test
    void catalogTest() {
        sleep(200);
        step("Skip onboarding", Selenide::back);
        step("Set the Catalog", () -> {
            $(AppiumBy.accessibilityId("Каталог")).click();   //open catalog
            $(AppiumBy.id("ru.citilink:id/recyclerViewMainCategories"))  //click for category
                    .$(AppiumBy.id("ru.citilink:id/textViewMainCategoryTitle"))
                    .shouldHave(text("Смартфоны и гаджеты")).click();
        });

        step("Verify content found", () -> {
            $(AppiumBy.id("ru.citilink:id/textViewCustomTitle")).shouldHave(text("Смартфоны и гаджеты"));  //check to open the page of the catalog
        });
    }

    @Test
    void addToBasketTest() {
        sleep(200);
        step("Skip onboarding", Selenide::back);
        step("add product to basket", () -> {
            mobilePage.inputNameSearch("Смартфон Xiaomi 11");
            $(AppiumBy.id("ru.citilink:id/textViewSearchProductName"))
                    .click();
            $(AppiumBy.id("ru.citilink:id/buttonProductAddToCart")).click();
        });

        step("Verify to add product", () -> {
            $(AppiumBy.id("ru.citilink:id/ordering_graph")).click();
            $(AppiumBy.id("ru.citilink:id/constraintLayoutCartProduct"))
                    .$(AppiumBy.id("ru.citilink:id/textViewCartProductName"))
                    .shouldHave(text("Смартфон Xiaomi"));
        });
    }


}
