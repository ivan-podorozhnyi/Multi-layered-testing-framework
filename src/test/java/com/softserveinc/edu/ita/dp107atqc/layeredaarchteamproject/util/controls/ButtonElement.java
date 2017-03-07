package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;


public class ButtonElement implements Button {

    private ControlWrapper control;

    public ButtonElement(ControlWrapper control) {
        this.control = control;
    }

    @Override
    public void click() {
        control.click();
    }

    @Override
    public boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public String getText() {
        return control.getText();
    }

    private static Button get(ControlLocation location) {
        return new ButtonElement(new ControlWrapper(ContextVisible.get().get(location)));
    }

    public static Button getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static Button getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static Button getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static Button getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static Button getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static Button getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static Button getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }


}
