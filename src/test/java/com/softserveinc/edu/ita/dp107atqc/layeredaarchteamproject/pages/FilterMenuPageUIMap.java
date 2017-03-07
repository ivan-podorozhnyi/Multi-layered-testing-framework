package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.DropDownElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;


public class FilterMenuPageUIMap {
    private DropDown selectCategory;
    private DropDown selectStatus;
    private Button applyButton;

    public FilterMenuPageUIMap() {
        this.selectCategory = DropDownElement.getById("SelectedCateg");
        this.selectStatus = DropDownElement.getById("SelectedStatus");
        this.applyButton = ButtonElement.getByCss("#applybutton");
    }

    public void selectCategory(String text) {
        this.selectCategory.selectByVisibleText(text);
    }

    public void selectStatus(String text) {
        this.selectStatus.selectByVisibleText(text);
    }

    public void apply() {
        this.applyButton.click();
    }

    public DropDown checkSelectedCategory() {
        return this.selectCategory;
    }

    public DropDown checkSelectedStatus() {
        return this.selectStatus;
    }

    public Button getApplyButton(){
        return this.applyButton;
    }

    public DropDown getSelectCategoryDropDown() {
        return selectCategory;
    }

    public DropDown getSelectStatusDropDown() {
        return selectStatus;
    }
}
