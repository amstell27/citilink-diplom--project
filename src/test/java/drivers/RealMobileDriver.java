package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;


public class RealMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
//        options.setDeviceName("RFCR90ZMNQP");
        options.setDeviceName("Pixel_4_API_30");
        options.setPlatformVersion("11.0");
        options.setApp(app.getAbsolutePath());
        options.setLocale("ru");
        options.setLanguage("ru");
        options.setAppPackage("ru.citilink");
        options.setAppActivity("ru.citilink.app.presentation.mainactivity.MainActivity");



        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File getApp() {
        String appPath = "src/test/resources/apk/сitilink-1.5.0.apk";
        String appUrl = "https://softdaily.ru/download/c/Citilink-1.5.0.apk";

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            }
            catch (IOException e) {
                throw new AssertionError("Failed to download apk", e);
            }
        }
        return app;
    }

}