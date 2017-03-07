package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapperSelect;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;

import java.util.List;

/**
 * Created by Sasha on 16.02.2017.
 */public class DropDownElement implements DropDown {
    private ControlWrapperSelect control;

    private DropDownElement(ControlWrapperSelect control) {
        this.control = control;
    }


    @Override
    public void selectByText(String optionText) {
        control.selectOptionByText(optionText);
    }

    @Override
    public void selectByValue(String optionValue) {
        control.selectOptionByValue(optionValue);
    }

    @Override
    public void selectByVisibleText(String text) {
        control.selectOptionByVisibleText(text);
    }

    @Override
    public void selectByIndex(int optionIndex) {
        control.selectOptionByIndex(optionIndex);
    }

    @Override
    public String getSelectedOption() {
        return control.getSelectedOption();
    }

    @Override
    public List<String> getAllOptions() {
        return control.getAllOptions();
    }

    @Override
    public boolean isDisplayed() {
        return control.isDisplayed();
    }

    private static DropDown get(ControlLocation controlLocation) {
        return new DropDownElement(new ControlWrapperSelect(ContextVisible.get().get(controlLocation)));
    }

    public static DropDown getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public static DropDown getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static DropDown getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static DropDown getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static DropDown getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }
}
