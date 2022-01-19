package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.ArticlePageObject;

public class IosArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TITLE = "id:{SUBSTRING}";
        BACK_BUTTON = "id:Search";
        SAVE_TO_READING_LIST_BUTTON = "id:Save for later";
        ADD_TO_READING_LIST_BUTTON = "id:Add “{SUBSTRING}” to a reading list?";
    }

    public IosArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
