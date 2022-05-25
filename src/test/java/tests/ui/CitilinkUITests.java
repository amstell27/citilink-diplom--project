package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class CitilinkUITests extends TestBaseUI {

    @DisplayName("Проверка выбора региона")
    @ValueSource(strings = {"Новосибирск", "Санкт-Петербург"})
    @ParameterizedTest(name = "\"{0}\"")
    void regionTest(String region) {

        step("Открываем основную страницу", () -> mainPage.openPage());
        step("Ввод региона", () -> {
            mainPage.openThePageRegion();
            regionPage.inputRegion(region);
            regionPage.choiceRegion(region);
        });
        step("Обновление страницы", () -> mainPage.refreshPage());
        step("Проверка региона", () -> mainPage.checkRegion(region));
    }

    @DisplayName("Проверка отображения данных, введенных в поиске")
    @ValueSource(strings = {"Процессоры", "Модули памяти"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {

        step("Открываем основную страницу", () -> mainPage.openPage());
        step("Ввод продукта", () -> mainPage.choiceInSearch(value));
        step("Проверка поиска", () -> searchPage.checkSearch(value));
    }

    @Test
    @DisplayName("Проверка раздела <Популярные категории>")
    void checkPopularCategory() {

        step("Открываем основную страницу", () -> mainPage.openPage());
        step("Проверяем раздел <Популярные категории>", () -> {
            mainPage.clickPopularCategory();
            mainPage.checkPopularCategory("Смартфоны");
        });
    }

    @DisplayName("Проверка отображения введенных сведений в разделе <Каталог товаров> ")
    @ValueSource(strings = {"Умный дом и системы безопасности", "Автотовары", "Строительство и ремонт"})
    @ParameterizedTest(name = "\"{0}\"")
    void checkCatalog(String categoryOfCatalog) {

        step("Открываем основную страницу", () -> mainPage.openPage());
        step("Проверка раздела <Каталог товаров>", () -> {
            mainPage.openCatalog();
            mainPage.choiseItem(categoryOfCatalog);
            mainPage.checkItem(categoryOfCatalog);
        });
    }

    @Test
    @DisplayName("Проверка раздела <Хиты>")
    void checkChapterOfHits() {

        step("Открываем основную страницу", () -> mainPage.openPage());
        step("Проверка раздела <Хиты>", () -> {
            mainPage.checkCatalogHits();
            hitPage.topProduct();
        });
    }

}
