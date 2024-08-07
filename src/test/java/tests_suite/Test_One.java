package tests_suite;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests_base.BaseTest;

public class Test_One extends BaseTest {
    private LoginPage page;
    private String parentUseCaseName;
    private String childUseCaseName;

    @BeforeClass
    private void createTest() {
        parentUseCaseName = "Login";
        childUseCaseName = "Login into App using valid credentials";

        // add use case name here
        extentReport.createParentTest(parentUseCaseName, "Verify user can login into app");

        //add scenarios name here
        extentReport.createChildTest(parentUseCaseName, childUseCaseName, "Verify User can login into the app using valid credentials");
    }


    @Test
    public void enterEmail() {
        page = new LoginPage(driver, platformName);
        //add this for steps
        extentReport.createGrandChildTest(childUseCaseName, "Enter Email", "Enter the email in the email field");

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
