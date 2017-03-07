package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CategoryPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainMenuPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ActivationTest {


    @BeforeClass
    public void setUp() {
//        File file = new File("C:\\Program Files\\Chromedriver\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriverUtils.getWebDriver();
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net");
        MainPage mainPage = new MainPage();
        createComment(mainPage, "123", "Comment123", true);
        createComment(mainPage, "124", "Comment124", true);
        createComment(mainPage, "125", "Comment125", false);
        createComment(mainPage, "126", "Comment126", false);

    }

    public void createComment(MainPage mainPage, String number, String name, boolean isActive) {
        CommentPage commentPage = mainPage.getMainMenuPage().clickOnNewButton();
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.clickMoveAllToSelectedCategory();
        if (isActive == true) {
            commentPage
                    .typeCommentNumber(number)
                    .typeCommentText(name)
                    .checkActivateCheckbox()
                    .clickOnSaveAndReturnButton();
        } else {
            commentPage
                    .typeCommentNumber(number)
                    .typeCommentText(name)
                    .uncheckActivateCheckbox()
                    .clickOnSaveAndReturnButton();
        }

    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.stop();
    }

    @Test
    public void TestCase1_ActiveCommentStayActive() {
        MainPage mainPage = new MainPage();
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("123"));
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectActiveInDropDown();

        Specification.get()
                .For(mainPage.getInfoLabel())
                .valueIsMatched("Comments were activated successfully")
                .next()
                .For(mainPage
                        .getCommentsTablePage().getCommentFromTableByNumber("123"))
                .commentsStatusIsMatched(true)
                .next()
                .check();
    }

    @Test
    public void TestCase2_InactiveCommentBecomesActive() {
        MainPage mainPage = new MainPage();
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("125"));
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectActiveInDropDown();

        Specification.get()
                .For(mainPage.getInfoLabel())
                .valueIsMatched("Comments were activated successfully")
                .next()
                .For(mainPage
                        .getCommentsTablePage().getCommentFromTableByNumber("125"))
                .commentsStatusIsMatched(true)
                .next()
                .check();
    }

    @Test
    public void TestCase3_InactiveCommentStaysInactive() {
        MainPage mainPage = new MainPage();
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("126"));
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectInActionInDropDown();

        Specification.get()
                .For(mainPage.getInfoLabel())
                .valueIsMatched("Comments were activated successfully")
                .next()
                .For(mainPage
                        .getCommentsTablePage().getCommentFromTableByNumber("126"))
                .commentsStatusIsMatched(true)
                .next()
                .check();
    }

    @Test
    public void TestCase4_ActiveCommentBecomesInactive() {
        MainPage mainPage = new MainPage();
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("124"));
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectInActionInDropDown();

        Specification.get()
                .For(mainPage.getInfoLabel())
                .valueIsMatched("Comments were activated successfully")
                .next()
                .For(mainPage
                        .getCommentsTablePage().getCommentFromTableByNumber("124"))
                .commentsStatusIsMatched(true)
                .next()
                .check();
    }
}
