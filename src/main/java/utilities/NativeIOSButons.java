package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NativeIOSButons extends SeleniumUtils{
    By doneButton = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");

    public NativeIOSButons(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnDoneButton(){
        clickOnElement(doneButton);
    }
}
