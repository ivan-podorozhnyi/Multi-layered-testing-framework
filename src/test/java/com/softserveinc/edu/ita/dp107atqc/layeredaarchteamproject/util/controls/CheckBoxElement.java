package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;


public class CheckBoxElement implements CheckBox {
    private ControlWrapper control;

    CheckBoxElement(ControlWrapper control) {
        this.control = control;
    }

    @Override
    public boolean isSelected() {
        return control.isSelected();
    }

    @Override
    public boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public String getValue() {
        return control.getAttribute("value");
    }

    @Override
    public void check() {
        if (!control.get().isSelected()) {
            control.click();
        }
    }

    @Override
    public void unCheck() {
      if (control.get().isSelected()) {
        control.click();
      }
    }

    private static CheckBox get(ControlLocation controlLocation) {
        return new CheckBoxElement(new ControlWrapper(ContextVisible.get().get(controlLocation)));
    }

    public static CheckBox getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static CheckBox getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static CheckBox getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static CheckBox getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static CheckBox getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static CheckBox getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static CheckBox getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }
}
