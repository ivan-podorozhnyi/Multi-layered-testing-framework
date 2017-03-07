package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

public class MainPage {
    private MainPageUIMap mainPageUIMap;

    public MainPage() {
        this.mainPageUIMap = new MainPageUIMap();
    }

    public CommentsTablePage getCommentsTablePage() {
        return new CommentsTablePage();
    }

    public CommentPage getCommentPage() {
        return new CommentPage();
    }

    public MainMenuPage getMainMenuPage() {
        return new MainMenuPage();
    }

    public FilterMenuPage getFilterMenuPage() {
        return new FilterMenuPage();
    }
    
    public Label getInfoLabel() {
        return mainPageUIMap.infoLabel();
    }
    
    public MainPage returnButton() {
        mainPageUIMap.returnButton().click();
        return this;
    }

    public DialogPage getdialogPage() {
        return  mainPageUIMap.dialogPage();
    }
}
