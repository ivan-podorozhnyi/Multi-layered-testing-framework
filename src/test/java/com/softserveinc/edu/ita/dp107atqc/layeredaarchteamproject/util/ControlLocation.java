package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.By;


public class ControlLocation {
    private By by;
    private String value;

    private ControlLocation(By by, String value) {
        this.by = by;
        this.value = value;
    }

    public By getBy() {
        return by;
    }

    public String getValue() {
        return value;
    }

    public static ControlLocation getById(String id) {
        return new ControlLocation(By.id(id) ,id);
    }

    public static ControlLocation getByName(String searchName) {
        return new ControlLocation(By.name(searchName), searchName);
    }

    public static ControlLocation getByXPath(String xpath) {
        return new ControlLocation(By.xpath(xpath), xpath);
    }

    public static ControlLocation getByCss(String css) {
        return new ControlLocation(By.cssSelector(css) ,css);
    }

    public static ControlLocation getByClassName(String className) {
        return new ControlLocation(By.className(className), className);
    }

    public static ControlLocation getByLinkText(String linkText) {
        return new ControlLocation(By.linkText(linkText), linkText);
    }

    public static ControlLocation getByPartialLinkText(String partLinkText) {
        return new ControlLocation(By.partialLinkText(partLinkText), partLinkText);
    }

    public static ControlLocation getByTagName(String tagame) {
        return new ControlLocation(By.tagName(tagame), tagame);
    }





}
