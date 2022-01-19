package ui.factories;

import io.appium.java_client.AppiumDriver;
import utils.Platform;
import org.openqa.selenium.WebElement;
import ui.WelcomePageObject;
import ui.ios.IosWelcomePageObject;

public class WelcomePageObjectFactory {
    public static WelcomePageObject get(AppiumDriver<WebElement> driver) throws Exception {
        final String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();
        WelcomePageObject welcomePageObject;

        if (platformNameFromEnv.equals(Platform.IOS_PLATFORM)) {
            welcomePageObject = new IosWelcomePageObject(driver);
        } else {
            welcomePageObject = null;
        }

        return welcomePageObject;
    }
}
