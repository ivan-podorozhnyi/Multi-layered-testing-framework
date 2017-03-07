package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapperList;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Table;

import java.util.List;


public class TableElement implements Table {
    private List<ControlWrapper> controls;

    @Override
    public int getSize() {
        return controls.size();
    }

    private TableElement (List<ControlWrapper> controls) {
        this.controls = controls;
    }

    private static Table get(ControlLocation controlLocation) {
       ControlWrapperList list = new ControlWrapperList(ContextVisible.get().getList(controlLocation));
        return new TableElement(list.getList());
    }

    public static Table getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public static Table getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public static Table getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public static Table getByCss(String css) {
        return get(ControlLocation.getByCss(css));
    }

    public static Table getByClassName(String className) {
        return get(ControlLocation.getByClassName(className));
    }

    public static Table getByLinkText(String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }

    public static Table getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public static Table getByTagName(String tag) {
        return get(ControlLocation.getByTagName(tag));
    }
}
