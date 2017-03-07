package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

public class MainMenuPage {
    private MainMenuPageUIMap mainMenuPageUIMap;

    public MainMenuPage() {
        this.mainMenuPageUIMap = new MainMenuPageUIMap();
    }

    public CommentPage clickOnNewButton() {
        mainMenuPageUIMap.newButton().click();
        return new CommentPage();
    }

    public CommentPage clickOnEditButton() {
        mainMenuPageUIMap.editButton().click();
        return new CommentPage();
    }
    
    public DialogPage clickOnDeleteButton() {
        mainMenuPageUIMap.deleteButton().click();
        return new DialogPage();
    }

    public CommentPage clickOnDuplicateButton() {
        mainMenuPageUIMap.duplicateButton().click();
        return new CommentPage();
    }

    public MainPage selectActiveInDropDown() {
        mainMenuPageUIMap.selectAnAction("Activate");
        return new MainPage();
    }
    
    public MainPage selectInActionInDropDown() {
        mainMenuPageUIMap.selectAnAction("Inactivate");
        return new MainPage();
    }
    
    public MainPage selectAnActionInDropDown() {
        mainMenuPageUIMap.selectAnAction("Select an Action");
        return new MainPage();
    }
    
    public MainPage selectRemoveFromCategoryInDropDown() {
        mainMenuPageUIMap.selectAnAction("RemoveFromCategory");
        return new MainPage();
    }
}
