package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.CommentsRepository;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.AlertPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentsTablePage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.CategoriesRepository.getCategoriesListByNumber;


public class removeFromCategoryTests {
    protected WebDriver driver;
    private Specification specification;

    @BeforeTest
    public void setUp() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }

    @AfterTest
    public void tearDown() {
        WebDriverUtils.stop();
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }

    @Test
    private void removeFromCategoryNotLastCategory() {
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidComment3())
                .getFilterMenuPage()
                .filterStatus("Active")
                .filterCategory("Cat5")
                .applyButton();
        CommentsTablePage commentTable = mainPage.getCommentsTablePage()
                .selectCommentWithCommentNumber(CommentsRepository.getValidComment3());
        mainPage.getMainMenuPage()
                .selectRemoveFromCategoryInDropDown()
                .getdialogPage()
                .clickOnYesButton()
                .returnButton();

        Specification.get()
                .For(commentTable.getCommentFromTableByNumber("335"))
                .commentsNotContainCategory("Cat5")
                .next()
                .check();
    }

    @Test
    private void removeFromCategoryLastCategoryActive() {
        Comment testComment1 = new Comment()
                .setCommentId("99")
                .setCommentText("Test comment ")
                .setActive(true)
                .setCategories(getCategoriesListByNumber(1));
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(testComment1)
                .getFilterMenuPage()
                .filterStatus("Active")
                .filterCategory("Cat1")
                .applyButton();
        CommentsTablePage commentTable = mainPage.getCommentsTablePage()
                .selectCommentWithCommentNumber(testComment1);
        mainPage.getMainMenuPage()
                .selectRemoveFromCategoryInDropDown()
                .getdialogPage()
                .clickOnYesButton()
                .getdialogPage()
                .clickOnYesButton()
                .returnButton();

        Specification.get()
                .For(commentTable.getCommentFromTableByNumber("99"))
                .commentsStatusIsMatched(false)
                .next()
                .check();
    }

    @Test
    private void removeFromCategoryCancelRemoving() {
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidComment2())
                .getFilterMenuPage()
                .filterStatus("Active")
                .filterCategory("Cat3")
                .applyButton();
        CommentsTablePage commentTable = mainPage.getCommentsTablePage()
                .selectCommentWithCommentNumber(CommentsRepository.getValidComment2());
        mainPage.getMainMenuPage()
                .selectRemoveFromCategoryInDropDown()
                .getdialogPage()
                .clickOnNoButton()
                .returnButton();

        Specification.get()
                .For(commentTable.getCommentFromTableByNumber("334"))
                .commentsContainCategory("Cat3")
                .next()
                .check();
    }

    @Test
    private void removeFromCategoryNotSelectedComment() {
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidComment1())
                .getFilterMenuPage()
                .filterStatus("Active")
                .filterCategory("Cat1")
                .applyButton();
        mainPage.getMainMenuPage()
                .selectRemoveFromCategoryInDropDown();

        Specification.get().For(new AlertPage())
                .compareText("Please, select one category")
                .next()
                .check();
    }

    @Test
    private void createValidComment() {
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidInactiveComment());
        Comment testComment = mainPage.getCommentsTablePage()
                .getCommentFromTableByNumber("124");

        Specification.get().For(CommentsRepository.getValidInactiveComment())
                .commentsNameIsMatched(testComment.getCommentText())
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentLongName() {
        MainPage mainPage = new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidTextComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("The maximum length of Comment "
                        + "Text field is 50 characters")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentEmptyComment() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getEmptyComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("The Comment Text field is required.")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentWithoutCategory() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidWithoutCategoryComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("Please, select at least one category")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentSymbolName() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidSymbolTextComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("The Comment Text field should"
                        + " contain alphanumeric characters only")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentSymbolNumber() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidSymbolNumberComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("Number field should contains only digits")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentLettersInNumber() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidLettersInNumberComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("Number field should contains only digits")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentExceedNumber() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getInvalidExceedNumberComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("The Number field should contain value from 0"
                        + " to 999")
                .next()
                .check();
    }

    @Test
    private void createInvalidCommentDuplicate() {
        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidActiveComment());

        new MainPage().getMainMenuPage()
                .clickOnNewButton()
                .saveAndReturnNewComment(CommentsRepository.getValidActiveComment());

        Specification.get().For(new CommentPage().getErrorLabel())
                .valueIsMatched("Comment already exists")
                .next()
                .check();
    }
}