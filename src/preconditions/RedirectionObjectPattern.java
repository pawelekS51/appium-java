package preconditions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedirectionObjectPattern extends BaseTest {

    private static final String REDIRECTION_ACTIVITY = ".app.RedirectEnter";
    private static final String PACKAGE = "io.appium.android.apis";

    private static String nameGoBtn = "go button";
    private static String nameTextField = "text field";
    private static String nameApplyBtn = "apply button";
    private static String nameClearBtn = "clear button";

    protected void startActivity() {
        driver.startActivity(new Activity(PACKAGE, REDIRECTION_ACTIVITY));
    }

    protected static AndroidElement returnGoButton() {
        //go button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/go")));
        AndroidElement goButton = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/go"));
        logger.info("Found required element - " + nameGoBtn);
        return goButton;
    }

    protected static AndroidElement returnTextBefore() {
        //text field before insert
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/text")));
        AndroidElement textBefore = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/text"));
        logger.info("Found required element - " + nameTextField);
        return textBefore;
    }

    protected static AndroidElement returnApplyBtn() {
        //apply button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/apply")));
        AndroidElement applyBtn = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/apply"));
        logger.info("Found required element - " + nameApplyBtn);
        return applyBtn;
    }

    protected static AndroidElement returnTextAfter() {
        //text field after insert
        WebDriverWait waitTextAfter = new WebDriverWait(driver, 10);
        waitTextAfter.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/text")));
        AndroidElement textAfter = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/text"));
        logger.info("Found required element - " + nameTextField);
        return textAfter;
    }

    protected static AndroidElement returnClearBtn() {
        //clear button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/clear")));
        AndroidElement clearBtn = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/clear"));
        logger.info("Found required element - " + nameClearBtn);
        return clearBtn;
    }
}