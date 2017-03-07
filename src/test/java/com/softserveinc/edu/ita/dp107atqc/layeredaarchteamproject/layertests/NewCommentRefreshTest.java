package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainMenuPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class NewCommentRefreshTest {

    private Specification specification;
    MainPage mainPage;
    MainMenuPage menu;
    CommentPage commentPage;

    @BeforeClass
    public void setUp() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
        specification = Specification.get();
        mainPage = new MainPage();
        menu = mainPage.getMainMenuPage();
        commentPage = menu.clickOnNewButton();

    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.stop();

    }


    @Test
    public void refreshCommentsPageWhenNothingIsEntered() {
        specification.For(commentPage.clickOnRefreshButton().
                getNumbInput()).valueMatch("").next().
                For(commentPage.getNameInput()).valueMatch("").next().
                For(commentPage.getStatusCheckbox()).isChecked();
        List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenAllIsEntered() {
        specification.For(commentPage.typeCommentNumber("554").
                typeCommentText("CommText1").
                uncheckActivateCheckbox().
                getCategoryPage().
                clickMoveAllToSelectedCategory().
                getCommentPage().clickOnRefreshButton().
                getNumbInput()).valueMatch("").next().
                For(commentPage.getNameInput()).valueMatch("").next().
                For(commentPage.getStatusCheckbox()).isChecked();

        List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }
        specification.check();

    }

    @Test
    public void refreshCommentsPageWhenCommentTextIsEntered() {
        specification.For(commentPage.typeCommentText("CommText2").
                clickOnRefreshButton().
                getNumbInput()).
                valueMatch("").next().
                For(commentPage.getNameInput()).valueMatch("").next().
                For(commentPage.getStatusCheckbox()).isChecked();
       List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshMainPageWhenCatIsSelected() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Cat0"));
        categories.add(new Category("Cat3"));
        specification.For(commentPage.getCategoryPage().selectCategories(categories).
                clickMoveToSelectedCategory().
                getCommentPage().
                clickOnRefreshButton().getNumbInput()).
                valueMatch("").next().
                For(commentPage.getNameInput()).valueMatch("").next().
                For(commentPage.getStatusCheckbox()).isChecked();

        List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }

        specification.check();

    }

    @Test
    public void refreshCommentsPageWhenCommentNumberIsEntered() {
        specification.
                For(commentPage.typeCommentNumber("555").
                        clickOnRefreshButton().
                        getNumbInput()).valueMatch("").next().
                For(commentPage.getNameInput()).valueMatch("").next().
                For(commentPage.getStatusCheckbox()).isChecked();
        List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenActCheckboxIsUnch() {
        specification.For(commentPage.uncheckActivateCheckbox().
                clickOnRefreshButton().getNumbInput()).
                valueMatch("").next().
                For(commentPage.getNumbInput()).
                valueMatch("").next().
                For(commentPage.getStatusCheckbox()).
                isChecked().next();
        List<CheckBox> checkboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox check : checkboxes) {
            specification.For(check).isUnChecked();
        }
        specification.check();
    }

}
