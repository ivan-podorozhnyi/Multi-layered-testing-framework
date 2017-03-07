package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.CommentsRepository;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainMenuPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Edit {
    @Test
    public void EditCommentInputValueValid ()  {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("2");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.clickOnEditButton();
        Comment comment1 = new Comment();
        comment1.setCommentText("abc");
        comment1.setCommentId("111");
        CommentPage commentPage1 = new CommentPage();
        commentPage1.clickOnSaveAndReturnButton();
        Specification.get()
                .For(comment1).commentsNumberIsMatched("111")
                .commentsNameIsMatched
                ("abc")
                .next()
                .check();
    }

    @Test
    public void EditCommentInputInvalidCommentTexts_50 () {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("10");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.clickOnEditButton();
        Comment comment1 = new Comment();
        comment1.setCommentText("asdfghjkloiuyhyhgtrfvbnhmjkogtthyyjukihgfghyjuiklodesfa");
        CommentPage commentPage = new CommentPage();
        commentPage.clickOnSaveAndReturnButton();
        Specification.get()
                .For(commentPage.getErrorLabel())
                .valueIsMatched("The maximum length " +
                "of Comment Text field is 50 characters")
                .next();
    }
    @Test
    public void CommentInputInvalidCommentTexts_50Repository () {
        MainPage mainPage = new MainPage();
        mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment(CommentsRepository
                .getInvalidTextComment());
        CommentPage commentPage = new CommentPage();
        Specification.get()
                .For(commentPage.getErrorLabel())
                .valueIsMatched("The maximum length " +
                "of Comment Text field is 50 characters")
                .next()
                .check();
    }

    @Test
    public void EditCommentInputValuetoCommentIdOfEmpty () {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("20");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.clickOnEditButton();
        Comment comment1 = new Comment();
        comment1.setCommentId("1");
        CommentPage commentPage = new CommentPage();
        commentPage.clickOnSaveAndReturnButton();
        Specification.get()
                .For(commentPage.getErrorLabel())
                .valueIsMatched("Number field should " +
                "be unique of empty")
                .next()
                .check();
    }
    @Test
    public void EditCommentInputValuetoCommentEmpty () {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("20");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.clickOnEditButton();
        Comment comment1 = new Comment();
        comment1.setCommentId("1000");
        CommentPage commentPage = new CommentPage();
        commentPage.clickOnSaveAndReturnButton();
        Specification.get()
                .For(commentPage.getErrorLabel())
                .valueIsMatched("The Number field should contain value from 0"
                + " to 999")
                .next()
                .check();
    }
    @Test
    public void EditCommentExists ()  {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("2");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = mainPage.getMainMenuPage();
        CommentPage commentPage =  mainMenuPage.clickOnEditButton();
        commentPage.clearCommenText();
        commentPage.typeCommentText("abc");
        commentPage.clickOnSaveAndReturnButton();
        MainPage mainPage1 = new MainPage();
        Comment comment1 = mainPage1.getCommentsTablePage().getCommentFromTableByNumber("3");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment1);
        MainMenuPage mainMenuPage1 = mainPage.getMainMenuPage();
        CommentPage commentPage1 =  mainMenuPage1.clickOnEditButton();
        commentPage1.clearCommenText();
        commentPage1.typeCommentText("abc");
        commentPage1.clickOnSaveAndReturnButton();
        Specification.get()
                .For(commentPage1.getErrorLabel())
                .valueIsMatched("Comment already " +
                "exists")
                .next()
                .check();
    }

    @Test
    public void EditCommentExistsWithRepository () {
        MainPage mainPage = new MainPage();
        mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment
                (CommentsRepository.getValidComment3());
        mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment
                (CommentsRepository.getValidComment3());
        CommentPage commentPage = new CommentPage();
        Specification.get()
                .For(commentPage.getErrorLabel())
                .valueIsMatched("Comment already exists")
                .next()
                .check();
    }
    @Test
    private void EditCommentInvalidCommentSymbolNumberWithRepositorycreate() {
        MainPage mainPage = new MainPage();
        mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment(CommentsRepository
                .getInvalidSymbolNumberComment());
        Specification.get()
                .For(new CommentPage().getErrorLabel())
                .valueIsMatched("Number field should contains only digits")
                .next()
                .check();
    }
    @Test
    private void  EditCommentInvalidCommentInvalidCommentNumber() {
        MainPage mainPage = new MainPage();
        mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment(CommentsRepository
                .getInvalidLettersInNumberComment());
        Specification.get()
                .For(new CommentPage().getErrorLabel())
                .valueIsMatched("Number field should contains only digits")
                .next()
                .check();
    }



    @BeforeTest
    public void setUp(){
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverUtils.stop();
    }

}
