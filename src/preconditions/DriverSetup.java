package preconditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

public class DriverSetup {

    protected static AndroidDriver<WebElement> driver;
    protected static AppiumDriverLocalService service;
    protected static Logger logger;

    public void serviceStart() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    private URL getServiceUrl() {
        return service.getUrl();
    }

    public void setUp() {
        startLogger();
        logger.info("Service has started.");

        File path = new File("src");
        File apk = new File(path, "ApiDemos-debug.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "test");
        caps.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<>(getServiceUrl(), caps);
    }

    private void startLogger() {
        logger = LoggerFactory.getLogger(DriverSetup.class);
    }

    public void tearDown() {
        driver.quit();
        logger.info("Service has stopped.");
    }

    public void serviceStop() {
        service.stop();
    }

}