package preconditions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedirectionObjectPattern extends BaseTest {

    private static final String REDIRECTION_ACTIVITY = ".app.RedirectEnter";
    private static final String PACKAGE = "io.appium.android.apis";

    protected void startActivity() {
        driver.startActivity(new Activity(PACKAGE, REDIRECTION_ACTIVITY));
    }

    protected static AndroidElement returnGoButton() {
        //go button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/go")));
        AndroidElement goButton = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/go"));
        return goButton;
    }

    protected static AndroidElement returnTextBefore() {
        //text field before insert
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/text")));
        AndroidElement textBefore = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/text"));
        return textBefore;
    }

    protected static AndroidElement returnApplyBtn() {
        //apply button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/apply")));
        AndroidElement applyBtn = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/apply"));
        return applyBtn;
    }

    protected static AndroidElement returnTextAfter() {
        //text field after insert
        WebDriverWait waitTextAfter = new WebDriverWait(driver, 10);
        waitTextAfter.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/text")));
        AndroidElement textAfter = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/text"));
        return textAfter;
    }

    protected static AndroidElement returnClearBtn() {
        //clear button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/clear")));
        AndroidElement clearBtn = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/clear"));
        return clearBtn;
    }
}