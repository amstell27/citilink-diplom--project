package tests.mobile;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.mobile.pages.MobilePages;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
public class AndroidSelenideTests extends TestBaseMobile {

    MobilePages mobilePage = new MobilePages();

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург"})
    @ParameterizedTest(name = "\"{0}\"")
    void setAndCheckRegion(String region) {

        sleep(2000);
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
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("Set the search", () -> {
            mobilePage.inputNameSearch(value)
                    .clickFoundCategory();
        });
        step("Verify content found", () -> {
            mobilePage.checkSearch(value);
        });
    }

    @DisplayName("Проверка выбора категории")
    @ValueSource(strings = {"Смартфоны и гаджеты"})
    @ParameterizedTest(name = "\"{0}\"")
    void catalogTest(String category) {
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("Set the Catalog", () -> {
            mobilePage.openCatalog()
                    .setCategory(category);
        });
        step("Verify content found", () -> {
            mobilePage.checkCategory(category);
        });
    }

    @Test
    void addToCartTest() {
        sleep(2000);
        step("Skip onboarding", Selenide::back);
        step("add product to basket", () -> {
            mobilePage.inputNameSearch("Смартфон Xiaomi 11")
                    .choiceProduct()
                    .addToCart();
        });
        step("Verify to add product", () -> {
            mobilePage.openTheCart()
                    .checkToAddProduct("Смартфон Xiaomi");
        });
    }
}
