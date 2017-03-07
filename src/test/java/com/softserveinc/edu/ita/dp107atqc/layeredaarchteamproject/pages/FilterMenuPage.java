package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;


public class FilterMenuPage {
    private FilterMenuPageUIMap filterMenuPageUIMap;

    public FilterMenuPage() {
        this.filterMenuPageUIMap = new FilterMenuPageUIMap();
    }

    public String getCategory() {
        return filterMenuPageUIMap.checkSelectedCategory().getSelectedOption();
    }

    public String getStatus() {
        return filterMenuPageUIMap.checkSelectedStatus().getSelectedOption();
    }

    public String getApplyButtonName(){
        return filterMenuPageUIMap.getApplyButton().getText();
    }

    public DropDown getCategoryFilterDropDown(){
        return filterMenuPageUIMap.getSelectCategoryDropDown();
    }

    public DropDown getStatusFilterDropDown(){
        return filterMenuPageUIMap.getSelectStatusDropDown();
    }

    public FilterMenuPage filterCategory(String categoryName) {
        filterMenuPageUIMap.selectCategory(categoryName);
        return  this;
    }

   public FilterMenuPage filterStatus(String statusName) {
       filterMenuPageUIMap.selectStatus(statusName);
       return  this;
    }

    public MainPage applyButton() {
      filterMenuPageUIMap.apply();
      return new MainPage();
    }

}
