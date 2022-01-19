package ui.factories;

import io.appium.java_client.AppiumDriver;
import utils.Platform;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IosSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver<WebElement> driver) throws Exception {
        SearchPageObject searchPageObject;
        final String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();

        switch (platformNameFromEnv) {
            case Platform.ANDROID_PLATFORM:
                searchPageObject = new AndroidSearchPageObject(driver);
                break;
            case Platform.IOS_PLATFORM:
                searchPageObject = new IosSearchPageObject(driver);
                break;
            default:
                searchPageObject = null;
                break;
        }

        return searchPageObject;
    }
}
