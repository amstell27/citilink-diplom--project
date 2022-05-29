package tests.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class RegionPage {

    private final SelenideElement
            inputCity = $(by("placeholder", "Введите название города")),
            choiceCity = $("[class='CitiesSearch__city-list']");

    public RegionPage inputRegion(String region) {
        inputCity.setValue(region);
        return this;
    }

    public RegionPage choiceRegion(String region) {
        choiceCity.click();
        return this;
    }

}
