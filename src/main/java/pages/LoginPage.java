package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utilities.NativeIOSButons;
import utilities.SeleniumUtils;

public class LoginPage extends SeleniumUtils {

    By emailAddress = By.xpath("//XCUIElementTypeTextField[@name=\"Email Text Field\nEnter email\"]");
    By initialPasswordLocator = By.xpath("//XCUIElementTypeTextField[contains(@name,'Password Text Field')]");
    By finalPasswordLocator = By.xpath("//XCUIElementTypeSecureTextField[contains(@name,'Password Text Field')]");
    By buttonLogin = By.xpath("//XCUIElementTypeStaticText[@name=\"Log in Button\nLog in\"]");
    By notification = By.xpath("//XCUIElementTypeStaticText[contains(@name,'Exception: invalid-credential')]");

    NativeIOSButons nativeIOSButons;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        nativeIOSButons = new NativeIOSButons(driver);
    }

    public void enterEmailAddress(String emailAddressString) {
        clickOnElement(emailAddress);
        enterTextInTextField(emailAddress, emailAddressString);

        nativeIOSButons.clickOnDoneButton();
    }

    public void enterPassword(String passwordString) {
        clickOnElement(initialPasswordLocator);
        clickOnElement(finalPasswordLocator);
        enterTextInTextField(finalPasswordLocator, passwordString);

        nativeIOSButons.clickOnDoneButton();
    }

    public void clickLoginButton() {
        clickOnElement(buttonLogin);
    }

    public String getNotificationText() {
        return getTextFromElement(notification);
    }
}
