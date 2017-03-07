package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces;

import java.util.List;


public interface DropDown {

    void selectByText(String text);

    void selectByValue(String value);

    void selectByVisibleText(String text);

    void selectByIndex(int index);

    String getSelectedOption();

    List<String> getAllOptions();

    boolean isDisplayed();

}
