package ui.factories;

import io.appium.java_client.AppiumDriver;
import utils.Platform;
import org.openqa.selenium.WebElement;
import ui.ReadingListPageObject;
import ui.android.AndroidReadingListPageObject;
import ui.ios.IosReadingListPageObject;

public class ReadingListPageObjectFactory {
    public static ReadingListPageObject get(AppiumDriver<WebElement> driver) {
        final String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();
        ReadingListPageObject readingListPageObject;

        switch (platformNameFromEnv) {
            case Platform.ANDROID_PLATFORM:
                readingListPageObject = new AndroidReadingListPageObject(driver);
                break;
            case Platform.IOS_PLATFORM:
                readingListPageObject = new IosReadingListPageObject(driver);
                break;
            default:
                readingListPageObject = null;
                break;
        }

        return readingListPageObject;
    }
}
