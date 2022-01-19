package ui;

import io.appium.java_client.AppiumDriver;
import utils.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public abstract class ArticlePageObject extends CorePageObject {
    public static String
            // Android and iOS
            ARTICLE_TITLE,
            BACK_BUTTON,
            SAVE_TO_READING_LIST_BUTTON,
            // Android only
            GOT_IT_BUTTON,
            // iOS only
            ADD_TO_READING_LIST_BUTTON;
    private Point addToReadingListButtonPoint; // iOS only

    public ArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSaveToReadingListButton() {
        // Вначале определяем приблизительные координаты для клика по всплывающему элементу iOS "Add {article_title} to a reading list?",
        // который не успеваем найти по id до его исчезновения
        if ((Platform.getInstance().isIOS()) && (addToReadingListButtonPoint == null)) {
            findAddToReadingListButtonPoint();
        }

        this.waitForElementAndClick(SAVE_TO_READING_LIST_BUTTON, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    private void findAddToReadingListButtonPoint() {
        int offsetFromSaveForLaterButton = 40;

        WebElement saveForLaterButton = this.waitForElementPresent(SAVE_TO_READING_LIST_BUTTON);
        addToReadingListButtonPoint = saveForLaterButton.getLocation();
        addToReadingListButtonPoint.y -= offsetFromSaveForLaterButton;
    }

    public void clickBackButton() {
        this.waitForElementAndClick(BACK_BUTTON);
    }

    public String getArticleTitleTextAndroid() {
        WebElement articleTitle = this.waitForElementPresent(ARTICLE_TITLE);
        return articleTitle.getText();
    }

    public String getArticleTitleTextIos(String articleTitleText) {
        final String articleTitleLocator;

        articleTitleLocator = getArticleTitleLocatorFromTemplate(articleTitleText);
        WebElement articleTitle = this.waitForElementPresent(articleTitleLocator);

        return articleTitle.getText();
    }

    public void clickGotItButtonAndroid() {
        this.waitForElementAndClick(GOT_IT_BUTTON, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public void clickAddToReadingListButton() throws Exception {
        Thread.sleep(1000);
        this.clickOnPoint(addToReadingListButtonPoint);
    }

    public void checkImageElementPresent(String resourcesImageFileName) throws Exception {
        this.waitForImageElementPresent(resourcesImageFileName);
    }

    /* TEMPLATES METHODS */
    private String getArticleTitleLocatorFromTemplate(String articleTitleText) {
        return this.replaceSubstringInTemplate(ARTICLE_TITLE, articleTitleText);
    }
    /* TEMPLATES METHODS */
}
