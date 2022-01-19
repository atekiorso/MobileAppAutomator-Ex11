package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import junit.framework.TestCase;
import utils.Platform;
import org.openqa.selenium.WebElement;

public class CoreTestCase extends TestCase {
    protected AppiumDriver<WebElement> driver;
    protected Platform platform;

    protected void setUp() throws Exception {
        driver = Platform.getInstance().getDriverByPlatformFromEnv();
        driver.setSetting(Setting.FIX_IMAGE_TEMPLATE_SIZE, true);
    }

    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
