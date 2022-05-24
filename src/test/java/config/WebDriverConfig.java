package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${UI}.properties"})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://citilink.ru")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("Chrome")
    String browserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();

}
