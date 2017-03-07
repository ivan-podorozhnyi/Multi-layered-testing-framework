package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.TextInput;

public class CommentPage {
    private CategoryPage CategoryPage;
    private CommentPageUIMap CommentPageUIMap;

    public CommentPage() {
        this.CommentPageUIMap = new CommentPageUIMap();
        this.CategoryPage = new CategoryPage();
    }

    public CategoryPage getCategoryPage () {
        return this.CategoryPage = new CategoryPage();
    }

    public CommentPage clickOnRefreshButton() {
        CommentPageUIMap.getRefreshButton().click();
        return new CommentPage();
    }

    public CommentPage clickOnSaveButton() {
        CommentPageUIMap.getSaveButton().click();
        return new CommentPage();
    }

    public MainPage clickOnSaveAndReturnButton() {
        CommentPageUIMap.getSaveAndReturnButton().click();
        return new MainPage();
    }

    public CommentPage checkActivateCheckbox() {
        CommentPageUIMap.getCommentActivateCheckbox().check();
        return new CommentPage();
    }

    public CommentPage uncheckActivateCheckbox() {
        CommentPageUIMap.getCommentActivateCheckbox().unCheck();
        return new CommentPage();
    }

    public boolean statusActivateCheckbox() {
        return CommentPageUIMap.getCommentActivateCheckbox().isSelected();
    }

    public CommentPage typeCommentText(String name) {
        CommentPageUIMap.getCommentText().type(name);
        return new CommentPage();
    }

    public String getCommentTextValue() {
        return CommentPageUIMap.getCommentText().getValue();
    }

    public CommentPage typeCommentNumber(String number) {
        CommentPageUIMap.getCommentNumber().type(number);
        return new CommentPage();
    }

    public String getCommentNumber() {
        return CommentPageUIMap.getCommentNumber().getValue();
    }

    public CommentPage clearCommentNumber() {
        CommentPageUIMap.getCommentNumber().clear();
        return new CommentPage();
    }

    public CommentPage clearCommenText() {
        CommentPageUIMap.getCommentText().clear();
        return new CommentPage();
    }

    public CommentPage saveNewComment(Comment comment) {
        if (!comment.isActive()){
            uncheckActivateCheckbox();}
        else if(comment.isActive()){
            checkActivateCheckbox();}
        typeCommentText(comment.getCommentText());
        typeCommentNumber(comment.getCommentId());
        CategoryPage.selectCategories(comment.getCategories()).clickMoveToSelectedCategory();
        clickOnSaveButton();
        return new CommentPage();
    }

    public MainPage saveAndReturnNewComment(Comment comment) {
        if (!comment.isActive()){
            uncheckActivateCheckbox();}
        else if(comment.isActive()){
            checkActivateCheckbox();}
        typeCommentText(comment.getCommentText());
        typeCommentNumber(comment.getCommentId());
        CategoryPage.selectCategories(comment.getCategories()).clickMoveToSelectedCategory();
        clickOnSaveAndReturnButton();
        return new MainPage();
    }

    public TextInput getNameInput() {
        return CommentPageUIMap.getCommentText();
    }

    public TextInput getNumbInput() {
        return CommentPageUIMap.getCommentNumber();
    }

    public CheckBox getStatusCheckbox() {
        return CommentPageUIMap.getCommentActivateCheckbox();
    }

    public Label getErrorLabel() {
        return CommentPageUIMap.getErrorLabel();
    }
}
