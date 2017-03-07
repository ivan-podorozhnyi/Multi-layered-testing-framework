package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import java.util.List;


public class CategoryPage {

  private CategoryPageUIMap categoryPageUIMap;

  public CategoryPage() {
    categoryPageUIMap = new CategoryPageUIMap();
  }

  public CategoryPage clickMoveToSelectedCategory() {
    categoryPageUIMap.getMoveToSelectedCategory().click();
    return new CategoryPage();
  }

  public CategoryPage clickMoveToAvailableCategory() {
    categoryPageUIMap.getMoveToAvailableCategory().click();
    return new CategoryPage();
  }

  public CategoryPage clickMoveAllToSelectedCategory() {
    categoryPageUIMap.getMoveAllToSelectedCategory().click();
    return new CategoryPage();
  }

  public CategoryPage clickMoveAllToAvailableCategory() {
    categoryPageUIMap.getMoveAllToAvailableCategory().click();
    return new CategoryPage();
  }

  public List<CheckBox> getAvailableCategoriesCheckboxList() {
    return categoryPageUIMap.getAvailableCategoryCheckboxList();
  }

  public List<CheckBox> getSelectedCategoriesCheckboxList() {
    return categoryPageUIMap.getSelectedCategoryCheckboxList();
  }

  public Button getMoveToSelectedCategoryButton() {
    return categoryPageUIMap.getMoveToSelectedCategory();
  }

  public Button getMoveAllToSelectedCategoryButton() {
    return categoryPageUIMap.getMoveAllToSelectedCategory();
  }

  public Button getMoveToAvailableCategoryButton() {
    return categoryPageUIMap.getMoveToAvailableCategory();
  }

  public Button getMoveAllToAvailableCategoryButton() {
    return categoryPageUIMap.getMoveAllToAvailableCategory();
  }

  public CategoryPage selectCategories(List<Category> categories) {

    List<CheckBox> checkBoxes = categoryPageUIMap.getAvailableCategoryCheckboxList();
    checkBoxes.addAll(categoryPageUIMap.getSelectedCategoryCheckboxList());
    {
      for (Category category : categories) {
        for (CheckBox checkbox : checkBoxes) {
          if (Byte.parseByte(category.getCategory().replace("Cat", "")) + 1 == Byte.parseByte
                  (checkbox.getValue())) {
            checkbox.check();
          }
        }
      }
    }
    return new CategoryPage();
  }

  public CommentPage getCommentPage() {
    return new CommentPage();
  }

}
