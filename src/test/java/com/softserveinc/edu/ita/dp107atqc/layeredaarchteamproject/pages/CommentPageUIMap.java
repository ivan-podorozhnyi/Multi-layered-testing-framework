package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.TextInputElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.TextInput;


public class CommentPageUIMap {
    private Button RefreshButton;
    private Button SaveButton;
    private Button SaveAndReturnButton;
    private TextInput CommentText;
    private TextInput CommentNumber;
    private CheckBox CommentActivateCheckbox;
    private Label ErrorLabel;

    public Button getRefreshButton() {
        this.RefreshButton = ButtonElement.getByCss("#editor-navigation > a");
        return RefreshButton;
    }

    public Button getSaveButton() {
        this.SaveButton = ButtonElement.getByCss("#editor-navigation > input:nth-child(2)");
        return SaveButton;
    }

    public Button getSaveAndReturnButton() {
        this.SaveAndReturnButton = ButtonElement.getByCss("#editor-navigation > input:nth-child(3)");
        return SaveAndReturnButton;
    }

    public TextInput getCommentText() {
        this.CommentText = TextInputElement.getById("Text");
        return CommentText;
    }

    public TextInput getCommentNumber() {
        this.CommentNumber = TextInputElement.getById("Number");
        return CommentNumber;
    }

    public CheckBox getCommentActivateCheckbox() {
        this.CommentActivateCheckbox = CheckBoxElement.getByCss("#Active");
        return CommentActivateCheckbox;
    }

    public Label getErrorLabel() {
        this.ErrorLabel = LabelElement.getByCss("#errorfield");
        return ErrorLabel;
    }
}
