package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.AlertElement;


public class AlertPage {
    public AlertElement alertElement;

    public AlertPage() {
        this.alertElement = new AlertElement();
    }

    public void switchToAlert() {
        alertElement.get();
    }

    public void clickOnAccept() {
        alertElement.get().accept();
    }

    public String getText() {
        return alertElement.get().getText(); }

    }



