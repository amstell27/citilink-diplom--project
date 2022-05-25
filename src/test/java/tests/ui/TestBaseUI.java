package tests.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.DriverConfigUI;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.ui.pages.HitsPage;
import tests.ui.pages.MainPage;
import tests.ui.pages.RegionPage;
import tests.ui.pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBaseUI {

    MainPage mainPage = new MainPage();
    RegionPage regionPage = new RegionPage();
    SearchPage searchPage = new SearchPage();
    HitsPage hitPage = new HitsPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverConfigUI.configure();
    }

    @BeforeEach
    void openLabirint() {
        step("open citilink", () -> {
            open("https://www.citilink.ru/");
        });
    }

    @AfterEach
    void addAttachements(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
