package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import org.openqa.selenium.Alert;


    public class AlertElement {
    private ContextVisible control;
    private org.openqa.selenium.Alert alert;

    public AlertElement() {
        this.control = control;
    }

//    @Override
//    public void click() {
//    }
//
//    @Override
//    public String getText() {
//        return null;
//    }

   public Alert get( ) {
        this.alert = ContextVisible.get().getAlert();
        return alert;
    }

}

