package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.TextInput;


public class TextInputElement implements TextInput {

    private ControlWrapper control;

    public TextInputElement (ControlWrapper control) {
        this.control = control;
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
    public void clear() {
        control.clear();
    }

    @Override
    public void type(String text) {
        control.sendText(text);
    }

    @Override
    public void submit() {
        control.submit();
    }

    private static TextInput get(ControlLocation controlLocation) {
        return new TextInputElement(new ControlWrapper(ContextVisible.get().get(controlLocation)));
    }

    public static TextInput getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public static TextInput getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static TextInput getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static TextInput getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static TextInput getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static TextInput getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static TextInput getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static TextInput getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }
}
