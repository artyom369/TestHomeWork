package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Driver {

    public final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    public AndroidDriver androidDriver;
    public FluentWait wait;

    public Properties loadConfig(String sourceURL) throws Exception {

        String appConfigPath = RESOURCE_PATH + sourceURL;
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        return appProps;
    }

    private DesiredCapabilities getCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties config = loadConfig("appConfig.properties");

        String systemDeviceName = System.getenv("DEVICE_NAME");
        String deviceName = "";
        if (systemDeviceName != null && !systemDeviceName.isEmpty()) {
            deviceName = systemDeviceName;
        } else {
            deviceName = config.getProperty("DEVICE_NAME");
        }
        String systemPlatformVersion = System.getenv("PLATFORM_VERSION");
        String platformVersion = "";
        if (systemPlatformVersion != null && !systemPlatformVersion.isEmpty()) {
            platformVersion = systemPlatformVersion;
        } else {
            platformVersion = config.getProperty("PLATFORM_VERSION");
        }
        String systemAppSource = System.getenv("APP_SOURCE");
        String appSource = "";
        if (systemAppSource != null && !systemAppSource.isEmpty()) {
            appSource = systemAppSource;
        } else {
            appSource = config.getProperty("APP_SOURCE");
        }
        String env = System.getenv("ENV");
        String path = RESOURCE_PATH + appSource;
        if (env != null) {
            if (env.equals("docker")) {
                path = "/apk/";
            }
        }

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("udid", deviceName);
        capabilities.setCapability("app", path + "app-test.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        if (env != null) {
            if (env.equals("docker")) {
                capabilities.setCapability("remoteAdbHost", "host.docker.internal");
            }
        }

        return capabilities;
    }

    public AndroidDriver createDriver() throws Exception {
        Properties config = loadConfig("appium.properties");
        String systemAppiumIP = System.getenv("APPIUM_IP");
        String appiumIP = "";
        if (systemAppiumIP != null && !systemAppiumIP.isEmpty()) {
            appiumIP = systemAppiumIP;
        } else {
            appiumIP = config.getProperty("IP");
        }
        String systemAppiumPort = System.getenv("APPIUM_PORT");
        String appiumPort = "";
        if (systemAppiumPort != null && !systemAppiumPort.isEmpty()) {
            appiumPort = systemAppiumPort;
        } else {
            appiumPort = config.getProperty("PORT");
        }

        AndroidDriver androidDriver =
                new AndroidDriver(
                        new URL("http://" + appiumIP + ":" + appiumPort), getCapabilities());

        wait = new FluentWait(androidDriver);
        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);

        return androidDriver;
    }
}
