package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class ReadingListPageObject extends CorePageObject {
    public static String
            CREATE_NEW_BUTTON,
            READING_LIST_NAME_FIELD,
            CONFIRM_CREATION_BUTTON,
            EXISTING_READING_LIST_TEMPLATE,
            ARTICLE_IN_READING_LIST_TEMPLATE,
            // iOS only
            SYNC_SCREEN_CLOSE_BUTTON,
            READING_LISTS_SECTION_BUTTON,
            SWIPE_DELETE_ACTION_BUTTON;


    public ReadingListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickCreateNewButton() {
        this.waitForElementAndClick(CREATE_NEW_BUTTON);
    }

    public void sendKeysToReadingListNameInputField(String readingListName) {
        this.waitForElementAndSendKeys(READING_LIST_NAME_FIELD, readingListName);
    }

    public void clickConfirmCreationButton() {
        this.waitForElementAndClick(CONFIRM_CREATION_BUTTON);
    }

    public void clickExistingReadingList(String readingListName) {
        final String existingReadingListLocator = getExistingReadingListLocator(readingListName);
        this.waitForElementAndClick(existingReadingListLocator);
    }

    public void clickSyncScreenCloseButton() {
        this.waitForElementAndClick(SYNC_SCREEN_CLOSE_BUTTON);
    }

    public void clickReadingListsSectionButton() {
        this.waitForElementAndClick(READING_LISTS_SECTION_BUTTON);
    }

    public void clickSwipeDeleteActionButton() {
        this.waitForElementAndClick(SWIPE_DELETE_ACTION_BUTTON);
    }

    public void swipeArticleLeftToDelete(String articleTitle) {
        final String articleInReadingListXpath = getArticleInReadingListLocator(articleTitle);
        this.waitForElementAndSwipeLeft(articleInReadingListXpath);
    }

    public void clickArticleInReadingList(String articleTitle) {
        final String articleInReadingListXpath = getArticleInReadingListLocator(articleTitle);
        this.waitForElementAndClick(articleInReadingListXpath);
    }

    public boolean isArticlePresentInCurrentReadingList(String articleTitle) {
        final String articleXpath = getArticleInReadingListLocator(articleTitle);
        return this.isElementPresent(articleXpath);
    }

    /* TEMPLATES METHODS */
    private String getExistingReadingListLocator(String readingListName) {
        return this.replaceSubstringInTemplate(EXISTING_READING_LIST_TEMPLATE, readingListName);
    }

    private String getArticleInReadingListLocator(String articleTitle) {
        return this.replaceSubstringInTemplate(ARTICLE_IN_READING_LIST_TEMPLATE, articleTitle);
    }
    /* TEMPLATES METHODS */
}
