package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface WebDriverConfig extends Config {

    @Key("remote")
    @DefaultValue("http://10.155.56.61:4444/wd/hub/")
    String remote();

    @Key("user")
    String user();

    @Key("password")
    String password();

}
