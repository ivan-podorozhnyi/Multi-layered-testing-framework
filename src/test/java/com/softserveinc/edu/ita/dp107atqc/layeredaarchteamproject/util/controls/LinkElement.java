package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

/**
 * Created by stas on 2/14/17.
 */public class LinkElement implements Link {
    private ControlWrapper control;

    public LinkElement(ControlWrapper control) {
        this.control = control;
    }

    @Override
    public void click() {
        control.click();
    }

    @Override
    public String getText() {
        return control.getText();
    }

    private static LinkElement get(ControlLocation controlLocation) {
        return new LinkElement(new ControlWrapper(ContextVisible.get().get(controlLocation)));
    }

    public static Link getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public static Link getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static Link getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static Link getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static Link getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static Link getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static Link getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static Link getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }
}
