package drivers;

import com.codeborne.selenide.Configuration;

import config.Credentials;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriver {

    public static void configure() {

        Configuration.baseUrl = "https://citilink.ru";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "99.0");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Credentials.isRemoteWebDriver()) {
            String user = Credentials.config.user();
            String password = Credentials.config.password();
            String remote = Credentials.config.remote();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = "https://" + user + ":" + password + "@" + remote;
        }
        Configuration.browserCapabilities = capabilities;
    }

}
