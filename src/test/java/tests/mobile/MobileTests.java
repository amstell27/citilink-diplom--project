package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@Tag("mobile")
public class MobileTests extends TestBaseMobile {

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург"})
    @ParameterizedTest(name = "\"{0}\"")
    void setAndCheckRegion(String region) {
        step("Выбор региона", () -> {
            mobilePage.openProfile();
            profilePage.setRegionOptions();
            regionPage.searchIconClick()
                    .inputRegion(region)
                    .setRegion(region);
        });
        step("Проверка выбора региона", () -> profilePage.checkRegion(region));
    }

    @DisplayName("Проверка поиска")
    @ValueSource(strings = {"Модули памяти", "Процессоры"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {
        step("Поиск продукта", () -> {
            mobilePage.searchButton();
            searchPage.inputNameSearch(value)
                    .clickFoundCategory();
        });
        step("Проверка найденного продукта", () -> productSearchPage.checkSearch(value));
    }

    @DisplayName("Проверка выбора категории")
    @ValueSource(strings = {"Смартфоны и гаджеты"})
    @ParameterizedTest(name = "\"{0}\"")
    void catalogTest(String category) {
        step("Переход в каталог", () -> {
            mobilePage.openCatalog();
            categoryPage.setCategory(category);
        });
        step("Проверка выбора категории", () -> productCategoryPage.checkCategory(category));
    }

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addToCartTest() {
        step("Добавление в корзину", () -> {
            mobilePage.searchButton();
            searchPage.inputNameSearch("Смартфон Xiaomi 11")
                    .choiceProduct();
            productSearchPage.addToCart();
        });
        step("Проверка добавления товара", () -> {
            productSearchPage.openTheCart();
            cartPage.checkToAddProduct("Смартфон Xiaomi");
        });
    }
}
