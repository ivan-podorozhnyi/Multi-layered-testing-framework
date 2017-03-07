package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CategoryPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GropingByActiveStatusTest {
    
    @Test
    public void testFunctionGropingByActiveStatus() {

        Specification.get()
                .For(new MainPage().getFilterMenuPage().filterStatus("Active").applyButton()
                        .getCommentsTablePage().isAllCommentsWithStatus(true))
                .valueMatch(true)
                .next()
                .check();

    }
    
    @Test
    public void testFunctionGropingByInactiveStatus() {
    
        Specification.get()
                .For(new MainPage().getFilterMenuPage().filterStatus("Inactive").applyButton()
                        .getCommentsTablePage().isAllCommentsWithStatus(false))
                .valueMatch(true)
                .next()
                .check();
    }
    
    @Test
    public void testSortingByCategoryNameCat0() {

        Specification.get()
                .For(new MainPage().getFilterMenuPage().filterCategory("Cat0").applyButton()
                        .getCommentsTablePage()
                        .isAllCommentsWithCategory(new Category("Cat0")))
                .valueMatch(true)
                .next()
                .check();
    }
    
    @Test
    public void testSortingByCategoryNameCat1() {
        
        Specification.get()
                .For(new MainPage().getFilterMenuPage().filterCategory("Cat1").applyButton()
                        .getCommentsTablePage()
                        .isAllCommentsWithCategory(new Category("Cat1")))
                .valueMatch(true)
                .next()
                .check();
    }
    
    @Test
    public void testSortingByCategoryNameCat5() {

        Specification.get()
                .For(new MainPage().getMainMenuPage().clickOnNewButton()
                        .typeCommentText("MyComment").typeCommentNumber("123").checkActivateCheckbox()
                        .getCategoryPage().clickMoveAllToSelectedCategory()
                        .getCommentPage().clickOnSaveAndReturnButton()
                        .getFilterMenuPage().filterCategory("Cat5").applyButton()
                        .getCommentsTablePage()
                        .isAllCommentsWithCategory(new Category("Cat5")))
                .valueMatch(true)
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

        @AfterTest
    public void tearDown() {
        WebDriverUtils.stop();
    }
    
    private void createTenComments() {
        for (int i = 1; i < 11; i++) {
            int number = 123 + i + i;
            String comment = "MyComment" + i;
            MainPage mainPage = new MainPage();
            CommentPage commentPage = mainPage.getMainMenuPage().clickOnNewButton().typeCommentText
                    (comment).typeCommentNumber(Integer.toString(number))
                    .checkActivateCheckbox();
            new CategoryPage().clickMoveAllToAvailableCategory();
            new CategoryPage().clickMoveAllToSelectedCategory();
            commentPage.clickOnSaveAndReturnButton();
        }
    }
}
