package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/credentials.properties"})
public interface WebDriverConfig extends Config {

    @Key("remote")
    @DefaultValue("")
    String remote();

    @Key("user")
    String user();

    @Key("password")
    String password();

}
