package tests.ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.operadriver;

public class StartPage {

    private final SelenideElement
        cityHeader = $("[class='MainHeader__city-block']").$("[class='MainHeader__city']"),
        searchCategory = $("[class='MainHeader__search']").$(by("name", "text")),
        popularCategory = $("[class='dy--PopularCategoriesBox__title']").$(by("data-owox-name", "Популярные категории")),
        catalog =  $("[data-label='Каталог товаров']"),
        hits = $("[data-dy-widget-id='123186']");

    @Step("Открыть страницу")
    public StartPage openPage() {
        Configuration.browser = "opera";
        open("");
        return this;
    }

    @Step("Обновить страницу")
    public StartPage refreshPage() {
        refresh();
        return this;
    }

    @Step("Выбор региона")
    public StartPage setRegion(String region) {
        cityHeader.click();
        $(by("placeholder","Введите название города")).setValue(region);
        $("[class='CitiesSearch__highlight']").click();
        return this;
    }

    @Step("Проверка выбранного региона")
    public StartPage checkRegion(String region) {
        cityHeader.shouldHave(text(region));
        return this;
    }

    @Step("Проверка поиска")
    public StartPage checkSearch(String value) {
        searchCategory.setValue(value).pressEnter();
        $("[class='Subcategory__title-container']").shouldHave(text(value));
        return this;
    }

    @Step("Проверка раздела 'Популярные категории'")
    public StartPage checkPopularCategory(String category) {
        popularCategory.click();
        $("[class='dy-container-1048403 dy--PopularCategoriesBox__container']").shouldHave(text(category));
        return this;
    }

    @Step("Проверка 'Каталога товаров'")
    public StartPage checkCatalog(String categoryOfCatalog) {
        catalog.click();
        $(by("data-title", categoryOfCatalog)).hover();
        $("[class='CatalogMenu__right js--CatalogMenu__right']").shouldHave(text(categoryOfCatalog));
        return this;
    }

    @Step("Проверка раздела Хиты")
    public StartPage checkCatalogHits() {
        hits.scrollTo();
        $("[class= 'SectionHead__link SectionHead__link_desktop']").click();
        $("[class='TopHundred']").shouldHave(text("Популярное в Топ 100"));
        return this;
    }

}
