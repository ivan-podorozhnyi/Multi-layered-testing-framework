package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.*;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeleteCommentTest {
    Specification specification;
    MainPage mainPage;

    @BeforeClass
    public void setUp() {
//        File file = new File("C:\\Program Files\\Chromedriver\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriverUtils.getWebDriver();
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net");


    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.stop();
    }

    @AfterMethod
    public void tearMethodDown() {
        WebDriverUtils.getWebDriver().navigate().refresh();
    }



//    @AfterTest
//    public void tearTestDown(){
//        mainPage.returnButton();
//    }

    @Test(enabled = false)
    public void TestCase1_DeleteCommentFromTable_thereIsNoCommentInTheTable() {
        MainPage mainPage = new MainPage();
         CommentsTablePage commentsTablePage = mainPage.getCommentsTablePage();
      //  commentsTablePage.setPageNumber("1");
        Comment COMMENT_TO_DELETE = mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("1");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(COMMENT_TO_DELETE);
        MainMenuPage mainMenuPage = mainPage.getMainMenuPage();
        DialogPage dialogPage = mainMenuPage.clickOnDeleteButton();
        specification = Specification.get()
                .For(dialogPage.textOnDialog())
                .valueIsMatched("Are you sure you want to delete the selected item(s)?")
                .next();

        mainPage = dialogPage.clickOnYesButton();

        commentsTablePage = mainPage.getCommentsTablePage();


        specification.For(mainPage.getInfoLabel())
                .isVisible()
                .valueIsMatched("Selected comments are deleted successfully")
                .next()
                .For(commentsTablePage)
        .isCommentNotExistsOnTheTable(COMMENT_TO_DELETE)
                .next()
                .check();
        mainPage.returnButton();
    }

    @Test(enabled = false)
    public void TestCase2_StopDeletingCommentInDialogMenu_CommentExists() {
        MainPage mainPage = new MainPage();
        CommentsTablePage commentsTablePage= mainPage
                .getCommentsTablePage();
       // commentsTablePage.setPageNumber("1");
        Comment NOT_DELETED_COMMENT = commentsTablePage.getCommentFromTableByNumber("2");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(NOT_DELETED_COMMENT);
        MainMenuPage mainMenuPage = mainPage.getMainMenuPage();
        mainPage = mainMenuPage.clickOnDeleteButton()
                .clickOnNoButton();
        commentsTablePage = mainPage.getCommentsTablePage();
        // commentsTablePage.getCommentFromTableByNumber("1");
        Specification.get()
                .For(commentsTablePage)
                .isCommentExistsOnTheTable(NOT_DELETED_COMMENT)
                .next()
                .check();
        mainPage.returnButton();

    }

    @Test(enabled = false)
    public void TestCase3_TryToDeleteCommentWithNoCheckingIt_getAlertMessage() {
        MainPage mainPage = new MainPage();
        CommentsTablePage commentsTablePage = mainPage.getCommentsTablePage();
      //  commentsTablePage.setPageNumber("1");
        MainMenuPage mainMenuPage = mainPage.getMainMenuPage();
        mainMenuPage.clickOnDeleteButton();
        AlertPage alert = new AlertPage();
        Specification.get()
                .For(alert)
                .compareText("Please, select one category")
                .next()
                .check();
        alert.clickOnAccept();
        mainPage.returnButton();

    }

    @Test(enabled = false)
    public void TestCase4_DeleteCommentsFromTable_thereAreNoSuchCommentsInTheTable() {
        MainPage mainPage = new MainPage();
        CommentsTablePage commentsTablePage = mainPage.getCommentsTablePage();
       // commentsTablePage.setPageNumber("1");
        Comment COMMENT_1_TO_DELETE = mainPage
                .getCommentsTablePage().getCommentFromTableByNumber("3");
        Comment COMMENT2_TO_DELETE = mainPage.getCommentsTablePage().getCommentFromTableByNumber
                ("7");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber
                (COMMENT_1_TO_DELETE);
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(COMMENT2_TO_DELETE);
        MainMenuPage mainMenuPage = mainPage.getMainMenuPage();
        DialogPage dialogPage = mainMenuPage.clickOnDeleteButton();
        mainPage = dialogPage.clickOnYesButton();

       commentsTablePage = mainPage.getCommentsTablePage();

        Specification.get()
                .For(commentsTablePage)
                .isCommentNotExistsOnTheTable(COMMENT2_TO_DELETE)
                .next()
                .check();
        mainPage.returnButton();

    }


}
