package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;

public class DialogPage {
    private DialogPageUIMap dialogPageUIMap;
    
    public DialogPage() {
        this.dialogPageUIMap = new DialogPageUIMap();
    }
    
    public Label textOnDialog() {
        return dialogPageUIMap.textOnDialog();
    }
    
    public Label dialogTitle() {
        return dialogPageUIMap.dialogTitle();
    }
    
    public MainPage clickOnYesButton() {
        dialogPageUIMap.yesButton().click();
        return new MainPage();
    }
    
    public MainPage clickOnNoButton() {
        dialogPageUIMap.noButton().click();
        return new MainPage();
    }
}
