package tests.ui;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.ui.pages.StartPage;

import static io.qameta.allure.Allure.step;

@Tag("UI")
public class CitilinkUITests extends TestBaseUI {

    StartPage startPage = new StartPage();
    String category = "Смартфоны";

    @DisplayName("Проверка корректного определения региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург", "Саров"})
    @ParameterizedTest(name = "\"{0}\"")
    void regionTest(String region) {

        step("Открываем основную страницу", () -> {
            startPage.openPage();
        });
        step("Ввод региона", () -> {
            startPage.setRegion(region);
        });
        step("Обновление страницы", () -> {
            startPage.refreshPage();
        });
        step("Проверка региона", () -> {
            startPage.checkRegion(region);
        });
    }

    @DisplayName("Проверка отображения данных, введенных в поиске")
    @ValueSource(strings = {"Процессоры", "Модули памяти"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {

        step("Открываем основную страницу", () -> {
            startPage.openPage();
        });
        step("Проверка поиска", () -> {
            startPage.checkSearch(value);
        });
    }

    @Test
    @DisplayName("Проверка раздела <Популярные категории>")
    void checkPopularCategory() {

        step("Открываем основную страницу", () -> {
            startPage.openPage();
        });
        step("Проверяем раздел <Популярные категории>", () -> {
            startPage.checkPopularCategory(category);
        });

    }

    @DisplayName("Проверка отображения введенных сведений в разделе <Каталог товаров> ")
    @ValueSource(strings = {"Умный дом и системы безопасности", "Автотовары", "Строительство и ремонт"})
    @ParameterizedTest(name = "\"{0}\"")
    void checkCatalog(String categoryOfCatalog) {

        step("Открываем основную страницу", () -> {
            startPage.openPage();
        });
        step("Проверка раздела <Каталог товаров>", () -> {
            startPage.checkCatalog(categoryOfCatalog);
        });

    }

    @Test
    @DisplayName("Проверка раздела <Хиты>")
    void checkChapterOfHits() {

        step("Открываем основную страницу", () -> {
            startPage.openPage();
        });

        step("Проверка раздела <Хиты>", () -> {
            startPage.checkCatalogHits();
        });
    }

}
