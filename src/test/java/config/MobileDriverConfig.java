package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${mobile}.properties"})
public interface MobileDriverConfig extends Config{

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("appPath")
    String appPath();

    @Key("appUrl")
    String appUrl();

    @Key("mobile")
    String mobile();

}
