package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;

/**
 * Created by stas on 2/14/17.
 */public class LabelElement implements Label {

    private ControlWrapper control;

    LabelElement(ControlWrapper control) {
        this.control = control;
    }


    @Override
    public boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public String getValue() {
        return control.getText();
    }

    private static Label get(ControlLocation controlLocation) {
        return new LabelElement(new ControlWrapper(ContextVisible.get().get(controlLocation)));
    }

    public static Label getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public static Label getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static Label getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static Label getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static Label getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static Label getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static Label getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static Label getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }



}
