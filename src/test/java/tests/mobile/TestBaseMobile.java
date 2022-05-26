package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import config.MobileDriverConfig;
import drivers.EmulatorMobileDriver;
import drivers.RealMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBaseMobile {

    public static MobileDriverConfig mobileConfig = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

    @BeforeAll
    public static void setup() {

        addListener("AllureSelenide", new AllureSelenide());

        switch (mobileConfig.mobile()) {
            case "real":
                Configuration.browser = RealMobileDriver.class.getName();
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
    }
}
