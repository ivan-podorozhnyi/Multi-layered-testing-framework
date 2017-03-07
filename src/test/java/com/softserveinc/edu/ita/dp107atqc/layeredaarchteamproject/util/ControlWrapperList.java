package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ControlWrapperList {

    private List<WebElement> searchContext;

    public ControlWrapperList(List<WebElement> searchContext) {
        this.searchContext = searchContext;
    }

    public List<ControlWrapper> getList() {
        List<ControlWrapper> controlWrappers = new ArrayList<>();
        for (WebElement webElement: searchContext) {
            controlWrappers.add(new ControlWrapper(webElement));
        }
        return controlWrappers;
    }

}
