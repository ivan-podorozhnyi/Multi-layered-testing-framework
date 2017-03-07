package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CommentsRepository {

  public static Comment getValidActiveComment() {
    return new Comment("123", "First comment", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getValidInactiveComment() {
    return new Comment("124", "First comment2", false, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidExceedNumberComment() {
    return new Comment("1234", "First comment3", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidLettersInNumberComment() {
    return new Comment("12a", "First comment4", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidSymbolNumberComment() {
    return new Comment("@#$%^", "First comment5", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidSymbolTextComment() {
    return new Comment("128", "@#$%^", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidTextComment() {
    return new Comment("126",
            "First comment, too much test comment.................................", true,
            new ArrayList<>(Arrays.asList(new
                    Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getInvalidWithoutCategoryComment() {
    return new Comment("125", "New comment1", true, new ArrayList<>(Collections.emptyList()));
  }

  public static Comment getEmptyComment() {
    return new Comment("", "", true, new ArrayList<>(Collections.emptyList()));
  }

  public static Comment getValidComment1() {
    return new Comment("333", "New comment1", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"))));
  }

  public static Comment getValidComment2() {
    return new Comment("334", "New comment2", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"),new
            Category("Cat2"), new Category("Cat3"))));
  }

  public static Comment getValidComment3() {
    return new Comment("335", "New comment3", true, new ArrayList<>(Arrays.asList(new
            Category("Cat0"), new Category("Cat1"),new
            Category("Cat4"), new Category("Cat5"))));
  }


}
