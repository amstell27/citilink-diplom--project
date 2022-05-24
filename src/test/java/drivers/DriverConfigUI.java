package drivers;

import com.codeborne.selenide.Configuration;

import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfigUI {

    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configure() {

        Configuration.browser = webConfig.browserName();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = webConfig.remoteUrl();
        }
        Configuration.browserCapabilities = capabilities;

    }

    public static boolean isRemoteWebDriver() {
        return !webConfig.remoteUrl().equals("");
    }

}
