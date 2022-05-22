package tests.mobile;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBaseMobile {
    @Test
    void searchTest() {

        step("Skip onboarding", Selenide::back);
        step("Set the city", () -> {
            $(AppiumBy.id("ru.citilink:id/profile_graph")).click();
            $(AppiumBy.id("ru.citilink:id/contentProfileCityRow"))
                    .click();
                    $(AppiumBy.id("ru.citilink:id/searchMenu")).click();
                            $(AppiumBy.id("ru.citilink:id/search_src_text")).setValue("Казань");
                            $(AppiumBy.id("ru.citilink:id/textViewCityName")).click();

        });
        step("Verify content found", () -> {
            $(AppiumBy.id("ru.citilink:id/contentProfileCityRow")).shouldHave(text("Казань"));
        });
    }
}
