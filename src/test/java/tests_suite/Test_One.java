package tests_suite;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests_base.BaseTest;

public class Test_One extends BaseTest {
    private LoginPage page;

    @Test
    public void enterEmail() {
        page = new LoginPage(driver, platformName);
        page.enterEmailAddress("abc@gmail.com");
    }

    @Test(priority = 1)
    public void enterPassword() {
        page.enterPassword("123456");
    }

    @Test(priority = 2)
    public void clickOnLoginButton() {
        page.clickLoginButton();
    }

    @Test(priority = 2)
    public void verifyNotification() {
        String notificationText = page.getNotificationText();
        Assert.assertEquals(notificationText, "Exception: invalid-credential");
    }
}
