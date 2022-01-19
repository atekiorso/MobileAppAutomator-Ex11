package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.ReadingListPageObject;

public class IosReadingListPageObject extends ReadingListPageObject {
    static {
        CREATE_NEW_BUTTON = "xpath://XCUIElementTypeButton[@name='Create a new list']";
        READING_LIST_NAME_FIELD = "xpath://XCUIElementTypeTextField[@value='reading list title']";
        CONFIRM_CREATION_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        EXISTING_READING_LIST_TEMPLATE = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']/..";
        ARTICLE_IN_READING_LIST_TEMPLATE = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']/..";
        SYNC_SCREEN_CLOSE_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
        READING_LISTS_SECTION_BUTTON = "xpath://XCUIElementTypeButton[@name='Reading lists']";
        SWIPE_DELETE_ACTION_BUTTON = "xpath://XCUIElementTypeButton[@name='swipe action delete']";
    }

    public IosReadingListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
