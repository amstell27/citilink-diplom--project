package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private final SelenideElement
            setRegion = $(AppiumBy.id("ru.citilink:id/contentProfileCityRow")),
            checkRegion = $(AppiumBy.id("ru.citilink:id/textViewProfileCityValue"));

    public ProfilePage setRegionOptions() {
        setRegion.click();
        return this;
    }

    public ProfilePage checkRegion(String region) {
        checkRegion.shouldHave(text(region));
        return this;
    }

}
