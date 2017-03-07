package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentsTablePage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PagingTest {

    private Specification specification;

    @BeforeClass
    public void setUp() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
        specification = Specification.get();

    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.stop();

    }


    @Test
    public void pagingTest() {
        MainPage mainPage = new MainPage();
        Comment testComment1 = new Comment().setCommentId("29");
        Comment testComment2 = new Comment().setCommentId("1");
        CommentsTablePage table = mainPage.getCommentsTablePage();
        specification.
                For(table.setPageNumber("2"))
                .pageNumberMatch("2").
                isPageExists("<").next().
                For(table.setPreviousPage()).
                pageNumberMatch("1").isPageNotExists("<").next().
                For(table.setNextPage()).
                pageNumberMatch("2").next().
                For(table.selectCommentWithCommentNumber(testComment1).
                        getMainPage().getMainMenuPage().
                        clickOnDuplicateButton().
                        clearCommentNumber().
                        typeCommentNumber("888").
                        typeCommentText("0xxx").clickOnSaveAndReturnButton().
                        getCommentsTablePage()).
                isPageExists("4").next().
                For(table.selectCommentWithCommentNumber(testComment2).
                        getMainPage().getMainMenuPage().
                        clickOnDeleteButton().
                        clickOnYesButton().
                        getCommentsTablePage()).
                isPageNotExists("4");


        specification.check();
    }
}
