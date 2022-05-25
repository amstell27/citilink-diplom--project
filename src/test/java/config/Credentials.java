package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    public static boolean isRemoteWebDriver() {
        return !config.remote().equals("");
    }
}