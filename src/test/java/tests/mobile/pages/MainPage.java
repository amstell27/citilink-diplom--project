package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
            profile = $(AppiumBy.id("ru.citilink:id/profile_graph")),
            searchButton = $(AppiumBy.id("ru.citilink:id/buttonSearch")),
            catalog = $(AppiumBy.accessibilityId("Каталог"));

    public MainPage openProfile() {
        profile.click();
        return this;
    }

    public MainPage searchButton() {
        searchButton.click();
        return this;
    }

    public MainPage openCatalog() {
        catalog.click();
        return this;
    }

}

