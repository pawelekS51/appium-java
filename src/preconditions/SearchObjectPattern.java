package preconditions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchObjectPattern extends BaseTest {

    private static final String SEARCH_ACTIVITY = ".app.SearchInvoke";
    private static final String PACKAGE = "io.appium.android.apis";

    protected void startActivity() {
        driver.startActivity(new Activity(PACKAGE, SEARCH_ACTIVITY));
    }

    protected static AndroidElement returnSearchInput() {
        //Search text field
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/txt_query_prefill")));
        AndroidElement searchInput = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/txt_query_prefill"));
        return searchInput;
    }

    protected static AndroidElement startSearchBtn() {
        //Search button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.appium.android.apis:id/btn_start_search")));
        AndroidElement startSearchBtn = (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/btn_start_search"));
        return startSearchBtn;
    }

    protected static AndroidElement androidInput() {
        //Android system text field
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")));
        AndroidElement androidInput = (AndroidElement) driver.findElement(By.id("android:id/search_src_text"));
        return androidInput;
    }
}
