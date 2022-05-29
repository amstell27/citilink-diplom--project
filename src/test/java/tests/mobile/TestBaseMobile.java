package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.mobile.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBaseMobile {

    MainPage mobilePage = new MainPage();
    RegionPage regionPage = new RegionPage();
    ProfilePage profilePage = new ProfilePage();
    SearchPage searchPage = new SearchPage();
    ProductSearchPage productSearchPage = new ProductSearchPage();
    CategoryPage categoryPage = new CategoryPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();
    CartPage cartPage = new CartPage();

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = MobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
        sleep(2000);
        step("Пропуск баннера", Selenide::back);
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
    }
}
