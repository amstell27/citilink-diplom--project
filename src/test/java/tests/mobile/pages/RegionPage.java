package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegionPage {

    private final SelenideElement
            searchIcon = $(AppiumBy.id("ru.citilink:id/searchMenu")),
            inputCity = $(AppiumBy.id("ru.citilink:id/search_src_text")),
            choiceCity = $(AppiumBy.id("ru.citilink:id/textViewCityName"));

    public RegionPage searchIconClick() {
        searchIcon.click();
        return this;
    }

    public RegionPage inputRegion(String region) {
        inputCity.setValue(region);
        return this;
    }

    public RegionPage setRegion(String region) {
        choiceCity.shouldHave(text(region)).click();
        return this;
    }

}
