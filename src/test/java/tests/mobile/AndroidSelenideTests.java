package tests.mobile;

import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
public class AndroidSelenideTests extends TestBaseMobile {

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург"})
    @ParameterizedTest(name = "\"{0}\"")
    void setAndCheckRegion(String region) {

        sleep(2000);
        step("Пропуск баннера", Selenide::back);
        step("Выбор региона", () -> mobilePage.setRegion(region));
        step("Проверка выбора региона", () -> mobilePage.checkRegion(region));
    }

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Модули памяти", "Процессоры"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {
        sleep(2000);
        step("Пропуск баннера", Selenide::back);
        step("Поиск продукта", () -> {
            mobilePage.inputNameSearch(value)
                    .clickFoundCategory();
        });
        step("Проверка найденного продукта", () -> mobilePage.checkSearch(value));
    }

    @DisplayName("Проверка выбора категории")
    @ValueSource(strings = {"Смартфоны и гаджеты"})
    @ParameterizedTest(name = "\"{0}\"")
    void catalogTest(String category) {

        sleep(2000);
        step("Пропуск баннера", Selenide::back);
        step("Переход в каталог", () -> {
            mobilePage.openCatalog()
                    .setCategory(category);
        });
        step("Проверка выбора категории", () -> mobilePage.checkCategory(category));
    }

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void addToCartTest() {

        sleep(2000);
        step("Пропуск баннера", Selenide::back);
        step("Добавление в корзину", () -> {
            mobilePage.inputNameSearch("Смартфон Xiaomi 11")
                    .choiceProduct()
                    .addToCart();
        });
        step("Проверка добавления товара", () -> {
            mobilePage.openTheCart()
                    .checkToAddProduct("Смартфон Xiaomi");
        });
    }
}
