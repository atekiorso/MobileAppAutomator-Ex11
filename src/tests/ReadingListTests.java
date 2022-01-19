package tests;

import utils.Platform;
import ui.*;
import ui.factories.*;

public class ReadingListTests extends CoreTestCase {
    private WelcomePageObject welcomePageObject;
    private MainPageObject mainPageObject;
    private SearchPageObject searchPageObject;
    private ArticlePageObject articlePageObject;
    private ReadingListPageObject readingListPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        welcomePageObject = WelcomePageObjectFactory.get(this.driver);
        mainPageObject = MainPageObjectFactory.get(this.driver);
        searchPageObject = SearchPageObjectFactory.get(this.driver);
        articlePageObject = ArticlePageObjectFactory.get(this.driver);
        readingListPageObject = ReadingListPageObjectFactory.get(this.driver);
    }

    public void testAddAndDeleteArticlesInReadingList() throws Exception {
        final String
                searchText = "star wars",
                readingListName = "Star Wars Reading List",
                firstArticleTitle = "Star Wars",
                secondArticleTitle = "Star Wars (film)",
                firstArticleImageResourcesFileName = "Star_Wars.png";

        // Закрываем приветственный экран
        if (Platform.getInstance().isIOS()) {
            welcomePageObject.clickSkipButton();
        }

        // Выполняем поиск и открываем первую статью
        mainPageObject.clickSearchField();
        searchPageObject.sendKeysToSearchInputField(searchText);
        searchPageObject.clickArticleTitleInSearchResults(firstArticleTitle);

        // Добавляем открытую статью в новый лист чтения
        articlePageObject.clickSaveToReadingListButton();
        if (Platform.getInstance().isAndroid()) {
            articlePageObject.clickGotItButtonAndroid();
        } else {
            articlePageObject.clickAddToReadingListButton();
            readingListPageObject.clickCreateNewButton();
        }
        readingListPageObject.sendKeysToReadingListNameInputField(readingListName);
        readingListPageObject.clickConfirmCreationButton();

        // Закрываем открытую статью, повторяем поиск и открываем вторую статью
        articlePageObject.clickBackButton();
        if (Platform.getInstance().isAndroid()) {
            // В Android возврат происходит к главному экрану, в iOS - к результатам предыдущешго поиска
            mainPageObject.clickSearchField();
            searchPageObject.sendKeysToSearchInputField(searchText);
        }
        searchPageObject.clickArticleTitleInSearchResults(secondArticleTitle);

        // Добавляем вторую статью в уже созданный лист чтения
        articlePageObject.clickSaveToReadingListButton();
        if (Platform.getInstance().isIOS()) {
            articlePageObject.clickAddToReadingListButton();
        }
        readingListPageObject.clickExistingReadingList(readingListName);

        articlePageObject.clickBackButton();
        if (Platform.getInstance().isIOS()) {
            searchPageObject.clickCancelSearchButton();
        }

        // Открываем лист чтения
        mainPageObject.clickReadingListsButton();
        if (Platform.getInstance().isIOS()) {
            readingListPageObject.clickSyncScreenCloseButton();
            readingListPageObject.clickReadingListsSectionButton();
        }
        readingListPageObject.clickExistingReadingList(readingListName);

        // Удаляем вторую статью из листа чтения через свайп влево
        readingListPageObject.swipeArticleLeftToDelete(secondArticleTitle);
        if (Platform.getInstance().isIOS()) {
            readingListPageObject.clickSwipeDeleteActionButton();
        }

        // Проверяем, что в нем осталась только первая статья
        assertTrue(readingListPageObject.isArticlePresentInCurrentReadingList(firstArticleTitle));
        assertFalse(readingListPageObject.isArticlePresentInCurrentReadingList(secondArticleTitle));

        // Открываем первую статью и проверяем графический элемент с логотипом Star Wars на соответствие заданному изображению
        readingListPageObject.clickArticleInReadingList(firstArticleTitle);
        articlePageObject.checkImageElementPresent(firstArticleImageResourcesFileName);
    }
}
