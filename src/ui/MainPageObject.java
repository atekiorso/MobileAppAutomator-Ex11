package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class MainPageObject extends CorePageObject {
    protected static String
            SEARCH_FIELD,
            READING_LISTS_BUTTON;

    public MainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSearchField() {
        this.waitForElementAndClick(SEARCH_FIELD);
    }

    public void clickReadingListsButton() {
        this.waitForElementAndClick(READING_LISTS_BUTTON);
    }
}
