package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final String CONTENT_DESCRIPTION = "content-desc";

    public SeleniumUtils(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickOnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void enterTextInTextField(By locator, String textToEnter) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(textToEnter);
    }

    public String getTextFromElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public String getContentDescription(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getAttribute(CONTENT_DESCRIPTION);
    }

    public void navigateBack() {
        driver.navigate().back();
    }


}
