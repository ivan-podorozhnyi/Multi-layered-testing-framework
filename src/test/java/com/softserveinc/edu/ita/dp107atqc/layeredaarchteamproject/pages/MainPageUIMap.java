package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LinkElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

public class MainPageUIMap {
    private Link returnButton;
    private Label infoLabel;
    private DialogPage dialogPage;

    public Link returnButton(){
        this.returnButton = LinkElement.getByCss("#logindisplay > a");
        return returnButton;
    }

    public Label infoLabel() {
        this.infoLabel = LabelElement.getById("infoField");
        return infoLabel;
    }

    public DialogPage dialogPage() {
        this.dialogPage = new DialogPage();
        return dialogPage;
    }

    public void open() {
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net/");
    }
}
