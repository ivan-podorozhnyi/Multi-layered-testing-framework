package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.AlertPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.CommentsTablePage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.DialogPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.*;
import org.testng.Assert;

public class Specification  {
    private boolean summaryResult;
    private StringBuilder summaryDescription;
    private static Specification instance;

    private Specification() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuilder();
    }

    public static Specification get() {

        return new Specification();

    }

    public boolean getPassed() {
        return summaryResult;
    }

    public String getDescription() {
        return summaryDescription.toString();
    }

    public void add(boolean pass, String errorText) {
        summaryResult = summaryResult && pass;
        if (!pass) {
            summaryDescription.append(errorText);
        }
    }

    public void check() {
        Assert.assertTrue(summaryResult, summaryDescription.toString());

    }

    public LinkCriteria For(Link link) {
        return LinkCriteria.get(link, this);
    }

    public CommentsTableCriteria For(CommentsTablePage commentsTablePage) {
        return CommentsTableCriteria.get(commentsTablePage, this);
    }

    public CommentCriteria For(Comment comment) {
        return CommentCriteria.get(comment, this);
    }

    public TextInputCriteria For(TextInput textInput) {
        return TextInputCriteria.get(textInput, this);
    }
    
    public LabelCriteria For(Label label) {
        return LabelCriteria.get(label, this);
    }
    
    public DropDownCriteria For(DropDown dropDown) {
        return DropDownCriteria.get(dropDown, this);
    }
    
    public CheckboxCriteria For(CheckBox checkBox) {
        return CheckboxCriteria.get(checkBox, this);
    }
    
    public ButtonCriteria For(Button button) {
        return ButtonCriteria.get(button, this);
    }
    
    public BooleanCriteria For(Boolean result) {
        return BooleanCriteria.get(result, this);
    }

    public AlertCriteria For (AlertPage alert) {return  AlertCriteria.get(alert, this); }

    public LabelCriteria For(DialogPage dialogPage){return LabelCriteria.get(dialogPage
            .textOnDialog(), this);}
}
