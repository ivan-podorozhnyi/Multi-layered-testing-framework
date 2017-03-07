package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapperList;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import java.util.ArrayList;
import java.util.List;


public class CategoryPageUIMap {

  private Button moveToSelectedCategory;
  private Button moveToAvailableCategory;
  private Button moveAllToSelectedCategory;
  private Button moveAllToAvailableCategory;
  private List<CheckBox> availableCategoryCheckboxList;
  private List<CheckBox> selectedCategoryCheckboxList;

  public Button getMoveToSelectedCategory() {
    this.moveToSelectedCategory = ButtonElement.getByName("CurSelect");
    return moveToSelectedCategory;
  }

  public Button getMoveAllToSelectedCategory() {
    this.moveAllToSelectedCategory = ButtonElement.getByName("AllSelect");
    return moveAllToSelectedCategory;
  }

  public Button getMoveToAvailableCategory() {
    this.moveToAvailableCategory = ButtonElement.getByName("CurUnSelectBtn");
    return moveToAvailableCategory;
  }

  public Button getMoveAllToAvailableCategory() {
    this.moveAllToAvailableCategory = ButtonElement.getByName("AllUnSelectBtn");
    return moveAllToAvailableCategory;
  }

  public List<CheckBox> getAvailableCategoryCheckboxList() {
    this.availableCategoryCheckboxList = getCategoryCheckboxList("#alvailablecategories");
    return availableCategoryCheckboxList;
  }

  public List<CheckBox> getSelectedCategoryCheckboxList() {
    this.selectedCategoryCheckboxList = getCategoryCheckboxList("#selectedCategories");
    return selectedCategoryCheckboxList;
  }

  // method gets a List of checkboxes depending on parent div
  public List<CheckBox> getCategoryCheckboxList(String categoryStatus) {
    List<CheckBox> checkBoxes = new ArrayList<>();
    if (categoryStatus.equals("#alvailablecategories")) {
      checkBoxes = getCategoryCheckboxes(
              String.format("%s>.categoryitem", categoryStatus), checkBoxes);
    }
    if (categoryStatus.equals("#selectedCategories")) {
      checkBoxes = getCategoryCheckboxes(
              String.format("%s>.categoryitem", categoryStatus), checkBoxes);
    }
    return checkBoxes;
  }

  private List<CheckBox> getCategoryCheckboxes(String location, List<CheckBox> checkBoxes) {
    if (ContextVisible.isElementPresentCheckByCss(location)) {
      byte numberOfElementsInDiv = (byte) new ControlWrapperList(ContextVisible.get().getList
              (ControlLocation.getByCss(location))).getList().size();
      for (byte i = 1; i <= numberOfElementsInDiv; i++) {
        checkBoxes.add(CheckBoxElement.getByCss(
                String.format(location + ":nth-child(%s)>input[type='checkbox']", i)));
      }
    }
    return checkBoxes;
  }

}
