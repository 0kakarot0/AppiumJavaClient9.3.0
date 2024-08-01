package tests_base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, getiOSOptions());
    }


    private UiAutomator2Options getAndroidOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("11");
        options.setAutomationName("UiAutomator2");
        options.setUdid("emulator-5554");
        options.setApp(System.getProperty("user.home") + "/IdeaProjects/AppiumJavaClient9.3.0/app/app-release.apk");
        options.setDeviceName("emulator");
        return options;
    }

//    platformName": "iOS",
//    "appium:options": {
//        "automationName": "XCUITest",
//        "platformVersion": "16.0",
//        "app": "/path/to/your.app",
//        "deviceName": "iPhone 12",
//        "noReset": true
//    }

    private XCUITestOptions getiOSOptions() {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setPlatformVersion("17.2");
        options.setAutomationName("XCUITest");
        options.setApp(System.getProperty("user.home") + "/IdeaProjects/AppiumJavaClient9.3.0/app/Runner.app");
        options.setDeviceName("iPhone 14");
        options.noReset();
        return options;
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}
