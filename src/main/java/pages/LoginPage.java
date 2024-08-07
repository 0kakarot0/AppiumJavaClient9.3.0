package pages;

import base_page.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.LocatorStore;
import utilities.NativeIOSButons;
import utilities.SeleniumUtils;

public class LoginPage extends BasePage {
    private static final String SCREEN_NAME = "loginScreen";

    By emailAddress;
    By initialPasswordLocator;
    By finalPasswordLocator;
    By loginButton;
    By notification;

    public LoginPage(AppiumDriver driver, String platformName) {
        super(driver, platformName);
        initializeLocators();
    }

    private void initializeLocators() {
        emailAddress = getLocator(SCREEN_NAME, "emailField", LocatorStore.LocatorType.XPATH);
        initialPasswordLocator = getLocator(SCREEN_NAME, "initialPasswordLocator", LocatorStore.LocatorType.XPATH);
        finalPasswordLocator = getLocator(SCREEN_NAME, "finalPasswordLocator", LocatorStore.LocatorType.XPATH);
        loginButton = getLocator(SCREEN_NAME, "loginButton", LocatorStore.LocatorType.XPATH);
        notification = getLocator(SCREEN_NAME, "errorNotification", LocatorStore.LocatorType.XPATH);
    }


    public void enterEmailAddress(String emailAddressString) {
        clickOnElement(emailAddress);
        enterTextInTextField(emailAddress, emailAddressString);
        doneOrNavigateBack();
    }

    public void enterPassword(String passwordString) {
        clickOnElement(initialPasswordLocator);

        if (isIOS()) {
            clickOnElement(finalPasswordLocator);
            enterTextInTextField(finalPasswordLocator, passwordString);
        } else {
            enterTextInTextField(initialPasswordLocator, passwordString);
        }
        doneOrNavigateBack();
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public String getNotificationText() {
        return isIOS() ? getTextFromElement(notification) : getContentDescription(notification);
    }

}
