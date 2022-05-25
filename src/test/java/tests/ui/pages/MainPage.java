package tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement

            cityHeader = $("[class='MainHeader__city-block']").$("[class='MainHeader__city']"),
            searchCategory = $("[class='MainHeader__search']").$(by("name", "text")),
            popularCategory = $("[class='dy--PopularCategoriesBox__header']"),
            oneOfThePopularCategory = $("[class='dy-container-1048403 dy--PopularCategoriesBox__container']"),
            catalog = $("[data-label='Каталог товаров']"),
            hoverCategory = $("[class='CatalogMenu__left js--CatalogMenu__left']"),
            checkToHoverCategory = $("[class='CatalogMenu__right js--CatalogMenu__right']"),
            hits = $("[data-dy-widget-id='123186']");

    public MainPage openPage() {
        open("");
        return this;
    }

    public MainPage refreshPage() {
        refresh();
        return this;
    }

    public MainPage openThePageRegion() {
        cityHeader.click();
        return this;
    }

    public MainPage checkRegion(String region) {
        cityHeader.shouldHave(text(region));
        return this;
    }

    public MainPage choiceInSearch(String value) {
        searchCategory.setValue(value).pressEnter();
        return this;
    }


    public MainPage clickPopularCategory() {
        popularCategory.click();
        return this;
    }

    public MainPage checkPopularCategory(String category) {
        oneOfThePopularCategory.shouldHave(text(category));
        return this;
    }

    public MainPage openCatalog() {
        catalog.click();
        return this;
    }

    public MainPage choiseItem(String categoryOfCatalog) {
        hoverCategory.$(by("data-title", categoryOfCatalog)).hover();
        return this;
    }

    public MainPage checkItem(String categoryOfCatalog) {
        checkToHoverCategory.shouldHave(text(categoryOfCatalog));
        return this;
    }

    public MainPage checkCatalogHits() {
        hits.scrollTo();
        $("[class= 'SectionHead__link SectionHead__link_desktop']").click();

        return this;
    }

}
