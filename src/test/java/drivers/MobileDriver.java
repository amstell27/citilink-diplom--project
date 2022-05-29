package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    private static MobileDriverConfig mobileConfig = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(mobileConfig.platformName());
        options.setDeviceName(mobileConfig.deviceName());
        options.setPlatformVersion(mobileConfig.platformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale("ru");
        options.setLanguage("ru");
        options.setAppPackage(mobileConfig.appPackage());
        options.setAppActivity(mobileConfig.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(mobileConfig.appiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appPath = mobileConfig.appPath();
        String appUrl = mobileConfig.appUrl();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }

}