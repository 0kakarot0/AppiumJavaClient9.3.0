package base_page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.LocatorStore;
import utilities.NativeIOSButons;
import utilities.SeleniumUtils;

public class BasePage extends SeleniumUtils {
    private final NativeIOSButons nativeIOSButons;
    private final LocatorStore locatorStore;
    private final String platformName;

    public BasePage(AppiumDriver driver, String platformName) {
        super(driver);
        this.platformName = platformName;
        nativeIOSButons = new NativeIOSButons(driver);
        locatorStore = new LocatorStore();
    }

    // Initialize common locators if any
    private void initializeCommonLocators() {

    }

    protected By getLocator(String screenName, String elementName, LocatorStore.LocatorType locatorType) {
        return By.xpath(locatorStore.getLocator(platformName, screenName, elementName, locatorType));
    }

    protected boolean isIOS() {
        return platformName.equalsIgnoreCase("ios");
    }

    protected void doneOrNavigateBack() {
        if (platformName.equalsIgnoreCase("ios")) {
            nativeIOSButons.clickOnDoneButton();
        } else {
            navigateBack();
        }
    }
}
