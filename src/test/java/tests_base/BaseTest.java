package tests_base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    protected static String platformName;
    protected static String deviceName;

    @BeforeTest
    public void setUp(ITestContext context) throws MalformedURLException, FileNotFoundException {
        URL url = new URL("http://127.0.0.1:4723/");
        platformName = context.getCurrentXmlTest().getParameter("platform");
        deviceName = context.getCurrentXmlTest().getParameter("deviceName");
        driver = new AppiumDriver(url, DeviceCapabilitiesManager.getDeviceCapabilitiesOptions(platformName,deviceName));
    }


    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}
