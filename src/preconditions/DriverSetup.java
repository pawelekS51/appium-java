package preconditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;

public class DriverSetup {

    protected static AndroidDriver<WebElement> driver;
    protected static AppiumDriverLocalService service;

    @BeforeClass
    public void setUp() {
        serviceStart();

        File path = new File("src");
        File apk = new File(path, "ApiDemos-debug.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "test");
        caps.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<>(getServiceUrl(), caps);
    }

    private URL getServiceUrl() {
        return service.getUrl();
    }

    private void serviceStart() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        serviceStop();
    }

    private void serviceStop() {
        service.stop();
    }

}