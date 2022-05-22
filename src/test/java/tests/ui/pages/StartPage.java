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
        popularCategory = $("[class='PopularCategoriesBox__header']"),
        catalog =  $("[data-label='Каталог товаров']"),
        hits = $("[data-dy-widget-id='123186']");

    public StartPage openPage() {
        open("");
        return this;
    }

    public StartPage refreshPage() {
        refresh();
        return this;
    }

    public StartPage setRegion(String region) {
        cityHeader.click();
        $(by("placeholder","Введите название города")).setValue(region);
        $("[class='CitiesSearch__highlight']").click();
        return this;
    }

    public StartPage checkRegion(String region) {
        cityHeader.shouldHave(text(region));
        return this;
    }

    public StartPage checkSearch(String value) {
        searchCategory.setValue(value).pressEnter();
        $("[class='Subcategory__title-container']").shouldHave(text(value));
        return this;
    }

    public StartPage checkPopularCategory(String category) {
        popularCategory.click();
        $("[class='dy-container-1048403 dy--PopularCategoriesBox__container']").shouldHave(text(category));
        return this;
    }

    public StartPage checkCatalog(String categoryOfCatalog) {
        catalog.click();
        $("[class='CatalogMenu__left js--CatalogMenu__left']").$(by("data-title", categoryOfCatalog)).hover();
        $("[class='CatalogMenu__right js--CatalogMenu__right']").shouldHave(text(categoryOfCatalog));
        return this;
    }

    public StartPage checkCatalogHits() {
        hits.scrollTo();
        $("[class= 'SectionHead__link SectionHead__link_desktop']").click();
        $("[class='TopHundred']").shouldHave(text("Популярное в Топ 100"));
        return this;
    }

}
