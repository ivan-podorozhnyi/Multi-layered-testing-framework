package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;

public class DialogPageUIMap {
    private Button yesButton;
    private Button noButton;
    private Label textOnDialog;
    private Label dialogTitle;
    
    
    public DialogPageUIMap() {
        this.yesButton = ButtonElement.getByCss("div > button:nth-child(1)");
        this.noButton = ButtonElement.getByCss("div > button:nth-child(2)");
        this.textOnDialog = LabelElement.getById("msgText");
        this.dialogTitle = LabelElement.getById("ui-dialog-title-dialog");
        
    }
    
    public Button yesButton() {
        return this.yesButton;
    }
    
    public Button noButton() {
        return this.noButton;
    }
    
    public Label textOnDialog() {
        return this.textOnDialog;
    }
    
    public Label dialogTitle() {
        return this.dialogTitle;
    }
}
