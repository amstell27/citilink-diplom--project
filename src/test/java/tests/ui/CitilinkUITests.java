package tests.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.ui.pages.StartPage;



public class CitilinkUITests extends TestBase{

    StartPage startPage = new StartPage();
    String category = "Смартфоны";

    @Disabled
    @DisplayName("Проверка корректного определения региона")
    @ValueSource(strings = {"Казань", "Санкт-Петербург", "Саров"})
    @ParameterizedTest(name = "\"{0}\"")
    void regionTest(String region) {
        startPage.openPage()
                .setRegion(region)
                .refreshPage()
                .checkRegion(region);
    }

    @Disabled
    @DisplayName("Проверка отображения данных, введенных в поиске")
    @ValueSource(strings = {"Процессоры", "Модули памяти"})
    @ParameterizedTest(name = "\"{0}\"")
    void searchTest(String value) {
        startPage.openPage()
                .checkSearch(value);
    }

    @Test
    @Disabled
    @DisplayName("Проверка раздела <Популярные категории>")
    void checkPopularCategory() {
        startPage.openPage()
                .checkPopularCategory(category);
    }

    @Disabled
    @DisplayName("Проверка отображения введенных сведений в разделе <Каталог товаров> ")
    @ValueSource(strings = {"Умный дом и системы безопасности", "Автотовары", "Строительство и ремонт"})
    @ParameterizedTest(name = "\"{0}\"")
    void checkCatalog(String categoryOfCatalog) {
        startPage.openPage()
                .checkCatalog(categoryOfCatalog);
    }

    @Test
    @Disabled
    @DisplayName("Проверка раздела <Хиты>")
    void checkChapterOfHits() {
        startPage.openPage()
                .checkCatalogHits();
    }

}
