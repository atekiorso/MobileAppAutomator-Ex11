package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.MainPageObject;

public class AndroidMainPageObject extends MainPageObject {
    static {
        SEARCH_FIELD = "id:org.wikipedia:id/search_container";
        READING_LISTS_BUTTON = "accessibility_id:My lists";
    }

    public AndroidMainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
