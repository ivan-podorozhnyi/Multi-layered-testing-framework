package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
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


public class EditCommentRefreshTest {

    private Specification specification;
    MainPage mainPage;
    MainMenuPage menu;
    CommentPage commentPage;
    Comment commentToCompare;

    @BeforeClass
    public void setUp() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
        specification = Specification.get();
        mainPage = new MainPage();
        menu = mainPage.getMainMenuPage();
        commentToCompare = mainPage.getCommentsTablePage().getCommentFromTableByNumber("1");
        mainPage.getCommentsTablePage().selectCommentWithCommentNumber(commentToCompare);
        commentPage = menu.clickOnEditButton();
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.stop();
    }


    @Test
    public void refreshCommentPageWhenNothingIsEntered() {
        specification.
                For(commentPage.clickOnRefreshButton().
                        getNumbInput())
                .valueMatch(commentToCompare.getCommentId()).next().
                For(commentPage.getNameInput()).
                valueMatch(commentToCompare.getCommentText()).next().
                For(commentPage.getStatusCheckbox())
                .isUnChecked().next();
        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenAllIsEntered() {
        specification.For(commentPage.
                clearCommentNumber().
                typeCommentNumber("667")
                .clearCommenText().
                        typeCommentText("New text").getCategoryPage().
                        clickMoveAllToSelectedCategory().getCommentPage().
                        clickOnRefreshButton().getNumbInput()).
                valueMatch(commentToCompare.getCommentId()).next().
                For(commentPage.getNameInput()).
                valueMatch(commentToCompare.getCommentText()).next().
                For(commentPage.getStatusCheckbox()).isUnChecked().next();
        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenTextIsEntered() {
        specification.For(commentPage.
                clearCommenText().
                typeCommentText("Comment Text 2").
                clickOnRefreshButton().
                getNumbInput()).
                valueMatch(commentToCompare.getCommentId()).next().
                For(commentPage.getNameInput()).valueMatch(commentToCompare.
                getCommentText()).next().
                For(commentPage.getStatusCheckbox()).isUnChecked().next();
        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentPageWhenNumberIsEntered() {
        specification.For(commentPage.
                clearCommentNumber().
                typeCommentNumber("667").
                clickOnRefreshButton().
                getNumbInput()).
                valueMatch(commentPage.getCommentNumber()).next().
                For(commentPage.getNameInput()).
                valueMatch(commentPage.getCommentTextValue()).next().
                For(commentPage.getStatusCheckbox()).isUnChecked().next();
        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage()
                .getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenCategoriesAreAdded() {
        List<Category> categoriesToAdd = new ArrayList<>();
        categoriesToAdd.add(new Category("Cat2"));
        categoriesToAdd.add(new Category("Cat4"));
        specification.For(commentPage.
                getCategoryPage().
                selectCategories(categoriesToAdd).
                clickMoveToSelectedCategory().
                getCommentPage().clickOnRefreshButton().
                getNumbInput()).
                valueMatch(commentToCompare.getCommentId()).next().
                For(commentPage.getNameInput()).
                valueMatch(commentToCompare.getCommentText()).next().
                For(commentPage.getStatusCheckbox()).isUnChecked().next();
        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }

    @Test
    public void refreshCommentsPageWhenActIsChecked() {
        specification.For(commentPage.
                checkActivateCheckbox().
                clickOnRefreshButton().
                getNumbInput()).
                valueMatch(commentToCompare.getCommentId()).next().
                For(commentPage.getNameInput()).
                valueMatch(commentToCompare.getCommentText()).next().
                For(commentPage.getStatusCheckbox()).isUnChecked().next();

        List<CheckBox> avalCheckboxes = commentPage.getCategoryPage().
                getAvailableCategoriesCheckboxList();
        for (CheckBox checkbox : avalCheckboxes) {
            specification.For(checkbox).isUnChecked();
        }
        List<CheckBox> selectcheckBoxes = commentPage.getCategoryPage().
                getSelectedCategoriesCheckboxList();
        for (CheckBox checkbox : selectcheckBoxes) {
            specification.For(checkbox).isUnChecked();
        }
        specification.check();
    }


}
