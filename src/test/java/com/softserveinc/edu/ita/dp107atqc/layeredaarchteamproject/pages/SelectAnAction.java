package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;


public class SelectAnAction {
  private SelectAnActionUIMap selectAnActionUIMap;

  public SelectAnAction(){
      this.selectAnActionUIMap = new SelectAnActionUIMap();
  }

    public void Activate(){
      selectAnActionUIMap.DropDownElement("Activate");
  }

    public void InActivate(){
        selectAnActionUIMap.DropDownElement("InActivate");
    }

  public MainPage filterMenuPage(){
      FilterMenuPage filterMenuPage = new FilterMenuPage();
      filterMenuPage.filterCategory("");
      filterMenuPage.applyButton();
      return new MainPage();
  }

    public void commentPage (String number){
        CommentsTablePage commentsTablePage = new CommentsTablePage();
        commentsTablePage.selectCommentWithCommentNumber(commentsTablePage.getCommentFromTableByNumber(number));
    }
    public void RemoveFromCategory(){
        selectAnActionUIMap.DropDownElement("RemoveFromCategory");
        selectAnActionUIMap.YesButton().click();
        selectAnActionUIMap.NoButton().click();
    }

}


