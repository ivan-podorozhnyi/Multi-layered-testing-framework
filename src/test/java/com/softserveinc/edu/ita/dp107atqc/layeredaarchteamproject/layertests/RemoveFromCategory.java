package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.*;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RemoveFromCategory {
    @Test
    public void Test_Remove_from_CategoryYes (){
        MainPage mainPage = new MainPage();
        mainPage.getFilterMenuPage().filterCategory("Cat1");
        mainPage.getFilterMenuPage().applyButton();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("1");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectRemoveFromCategoryInDropDown();
        new DialogPage().clickOnYesButton();
        FilterMenuPage filterMenuPage = mainPage.getFilterMenuPage();
        filterMenuPage.filterCategory("All");
        mainPage = filterMenuPage.applyButton();
        CommentsTablePage commentsTablePage = mainPage.getCommentsTablePage();
          mainPage.getCommentsTablePage();
       Specification.get()
               .For(comment)
               .commentsNotContainCategories("Cat1")
               .next();
    }
    @Test
    public void Test_Remove_from_CategoryNo () {
        MainPage mainPage = new MainPage();
        mainPage.getFilterMenuPage().filterCategory("Cat1");
        mainPage.getFilterMenuPage().applyButton();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("4");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectRemoveFromCategoryInDropDown();
        new DialogPage().clickOnNoButton();
        FilterMenuPage filterMenuPage = mainPage.getFilterMenuPage();
        filterMenuPage.filterCategory("All");
        mainPage = filterMenuPage.applyButton();
        CommentsTablePage commentsTablePage = mainPage.getCommentsTablePage();
        mainPage.getCommentsTablePage();
        Comment comment1 = null;
        Boolean resalt = true;
        Specification.get()
                .For(comment)
                .commentsNotContainCategories("Cat1")
                .next();
    }

    @Test
    public void Test_Remove_from_Category_AlertUsingFilter() throws InterruptedException {
        MainPage mainPage = new MainPage();
        Comment comment = mainPage.getCommentsTablePage().getCommentFromTableByNumber("9");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(comment);
        MainMenuPage mainMenuPage = new MainMenuPage();
        mainMenuPage.selectRemoveFromCategoryInDropDown();
        AlertPage alert = new AlertPage();
        alert.clickOnAccept();
        Specification.get().For(alert)
                .compareText("Please, select category using filter" )
                .next()
                .check();
    }

    @Test
    public void Test_Remove_from_Category_AlertselectOneCategory() throws InterruptedException {
       MainMenuPage mainMenuPage = new MainMenuPage();
       mainMenuPage.selectRemoveFromCategoryInDropDown();
       AlertPage alert = new AlertPage();
        Specification.get()
                .For(alert).compareText("Please, select one category")
                .next()
                .check();

    }


    @BeforeTest
    public void setUp(){
//       System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }

//    @BeforeMethod
//    public void setUpBeforeMethod() {
//        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
//    }

    @AfterTest
    public void tearDown() {
        WebDriverUtils.stop();
    }

    @AfterMethod
    public void tearMethodDown() {
        WebDriverUtils.getWebDriver().navigate().refresh();
    }

}
