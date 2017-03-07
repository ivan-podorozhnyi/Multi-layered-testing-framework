package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.CommentsRepository;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewCommentCreationTest {

  @DataProvider
  public static Object[][] validCommentsProvider() {
    return new Object[][]{{CommentsRepository.getValidComment1()}
            , {CommentsRepository.getValidComment2()}
            , {CommentsRepository.getValidComment3()}
    };
  }


  @Test(dataProvider = "validCommentsProvider")
  public void createValidNewCommentTestAndVerifyIsPresent(Comment comment) {
    MainPage mainPage = new MainPage();
    Specification.get()
            .For(mainPage.getMainMenuPage().clickOnNewButton().saveAndReturnNewComment(comment)
                    .getCommentsTablePage()).isCommentExistsOnTheTable(comment).next().check();
  }

  @DataProvider
  public static Object[][] invalidCommentsProvider() {
    return new Object[][]{{CommentsRepository.getEmptyComment()}
            , {CommentsRepository.getInvalidExceedNumberComment()}
            , {CommentsRepository.getInvalidLettersInNumberComment()}
            , {CommentsRepository.getInvalidSymbolNumberComment()}
            , {CommentsRepository.getInvalidSymbolTextComment()}
            , {CommentsRepository.getInvalidTextComment()}
            , {CommentsRepository.getInvalidWithoutCategoryComment()}
    };
  }

  @Test(dataProvider = "invalidCommentsProvider")
  public void createInvalidNewCommentTestAndVerifyIsPresent(Comment comment) {
    MainPage mainPage = new MainPage();
    Specification.get().For(mainPage.getMainMenuPage().clickOnNewButton().saveNewComment(comment)
            .getErrorLabel()).isVisible().next().check();
  }

  @BeforeMethod
  public void setUpBeforeMethod() {
    WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
  }

  @AfterTest
  public void tearDown() {
    WebDriverUtils.stop();
  }
}
