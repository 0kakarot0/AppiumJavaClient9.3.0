package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.LocatorStore;
import utilities.NativeIOSButons;
import utilities.SeleniumUtils;

public class LoginPage extends SeleniumUtils {
    private final static String SCREEN_NAME = "loginScreen";
    private final String platformName;

    By emailAddress;
    By initialPasswordLocator;
    By finalPasswordLocator;
    By loginButton;
    By notification;

    NativeIOSButons nativeIOSButons;
    LocatorStore locatorStore;

    public LoginPage(AppiumDriver driver, String platformName) {
        super(driver);
        this.platformName = platformName;
        nativeIOSButons = new NativeIOSButons(driver);
        locatorStore = new LocatorStore();
    }


    public void enterEmailAddress(String emailAddressString) {
        emailAddress = By.xpath(locatorStore.getLocator(platformName, SCREEN_NAME, "emailField", LocatorStore.LocatorType.XPATH));
        clickOnElement(emailAddress);
        enterTextInTextField(emailAddress, emailAddressString);
        doneOrNavigateBack();
    }

    public void enterPassword(String passwordString) {
        initialPasswordLocator = By.xpath(locatorStore.getLocator(platformName, SCREEN_NAME, "initialPasswordLocator", LocatorStore.LocatorType.XPATH));
        clickOnElement(initialPasswordLocator);

        if (platformName.equalsIgnoreCase("ios")) {
            finalPasswordLocator = By.xpath(locatorStore.getLocator(platformName, SCREEN_NAME, "finalPasswordLocator", LocatorStore.LocatorType.XPATH));
            clickOnElement(finalPasswordLocator);
            enterTextInTextField(finalPasswordLocator, passwordString);
        } else {
            enterTextInTextField(initialPasswordLocator, passwordString);
        }
        doneOrNavigateBack();
    }

    public void clickLoginButton() {
        loginButton = By.xpath(locatorStore.getLocator(platformName, SCREEN_NAME, "loginButton", LocatorStore.LocatorType.XPATH));
        clickOnElement(loginButton);
    }

    public String getNotificationText() {
        notification = By.xpath(locatorStore.getLocator(platformName, SCREEN_NAME, "errorNotification", LocatorStore.LocatorType.XPATH));
        return platformName.equalsIgnoreCase("ios") ? getTextFromElement(notification) : getContentDescription(notification);
    }

    private void doneOrNavigateBack() {
        if (platformName.equalsIgnoreCase("ios")) {
            nativeIOSButons.clickOnDoneButton();
        } else {
            navigateBack();
        }
    }
}
