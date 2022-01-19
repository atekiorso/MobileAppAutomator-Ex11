package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INPUT_FIELD = "id:org.wikipedia:id/search_src_text";
        CANCEL_SEARCH_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_TITLE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']";
        RESULT_BY_TITLE_AND_DESCRIPTION_TEMPLATE = "xpath://android.widget.LinearLayout" +
                "[.//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING1}']]" +
                "[.//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{SUBSTRING2}']]";
        RESULTS_TITLES = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";
    }

    public AndroidSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
