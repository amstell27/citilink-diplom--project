package drivers;

import com.codeborne.selenide.Configuration;

import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfigUI {

    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {

        Configuration.baseUrl = "https://citilink.ru";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "99.0");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = "https://" + webConfig.user() + ":" + webConfig.password() + "@" + webConfig.remote();
        }
        Configuration.browserCapabilities = capabilities;

    }

    public static boolean isRemoteWebDriver() {
        return !webConfig.remote().equals("");
    }

}
