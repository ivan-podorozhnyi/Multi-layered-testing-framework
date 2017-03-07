package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.DropDownElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;


public class SelectAnActionUIMap {
    private DropDownElement dropDownElement;
    private ButtonElement yes;
    private ButtonElement no;

    public SelectAnActionUIMap(){
        this.dropDownElement.getById("commandSelect");
    }
    public DropDownElement DropDownElement(String action) {
       this.dropDownElement.selectByValue("");
        return this.dropDownElement;
  }
    public ButtonElement YesButton(){
        if(yes == null){
           Button yes = ButtonElement.getByXpath
                   ("/html/body/div[2]/div[3]/div/button[1]/span");
        }
        return yes;
  }

    public ButtonElement NoButton(){
        if(no == null){
            Button yes = ButtonElement.getByXpath
                    ("/html/body/div[2]/div[3]/div/button[2]/span");
        }
        return no;
    }

  }


