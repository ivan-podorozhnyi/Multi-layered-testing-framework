package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.DropDownElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LinkElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

public class MainMenuPageUIMap {
    private Link newButton;
    private Link editButton;
    private Link duplicateButton;
    private Link deleteButton;
    private DropDown selectAnAction;

    public MainMenuPageUIMap() {
        this.newButton = LinkElement.getById("newbutton");
        this.editButton = LinkElement.getByCss("input[value='Edit..']");
        this.duplicateButton = LinkElement.getByCss("input[value='Duplicate...']");
        this.deleteButton = LinkElement.getByCss("input[value='Delete']");
        this.selectAnAction = DropDownElement.getById("commandSelect");
    }

    public Link newButton() {
        return this.newButton;
    }

    public Link editButton() {
        return this.editButton;
    }

    public Link duplicateButton() {
        return this.duplicateButton;
    }

    public Link deleteButton() {
        return this.deleteButton;
    }

    public DropDown selectAnAction(String action) {
        this.selectAnAction.selectByVisibleText(action);
        return this.selectAnAction;
    }
}
