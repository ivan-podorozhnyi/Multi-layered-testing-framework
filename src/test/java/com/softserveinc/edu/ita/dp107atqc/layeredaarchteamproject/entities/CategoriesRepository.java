package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CategoriesRepository {

  public static List<Category> getAllCategoriesList() {
    return new ArrayList<>(Arrays.asList(new Category("Cat0"), new Category
            ("Cat1"), new Category("Cat2"), new Category("Cat3"), new Category("Cat4"), new Category
            ("Cat5")));
  }

  public static List<Category> getCategoriesListByNumber(int ...categories) {

    ArrayList<Category> categoryArrayList = new ArrayList<>();
    for (int number : categories) {
      categoryArrayList.add(new Category("Cat" + number));
    }
    return categoryArrayList;
  }


}
