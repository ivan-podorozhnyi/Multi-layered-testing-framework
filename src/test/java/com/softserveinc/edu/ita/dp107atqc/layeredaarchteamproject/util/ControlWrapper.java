package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.WebElement;


public class ControlWrapper {

    private WebElement searchContext;

    public ControlWrapper (WebElement searchContext) {
        this.searchContext = searchContext;
    }

    public WebElement get() {
        return searchContext;
    }

    public void click() {
        searchContext.click();
    }

    public void clear() {
        searchContext.clear();
    }

    public void submit() {
        searchContext.submit();
    }

    public boolean isSelected() {
        return searchContext.isSelected();
    }

    public boolean isEnabled() {
        return searchContext.isEnabled();
    }

    public boolean isDisplayed() {
        return searchContext.isDisplayed();
    }

    public String getText() {
        return searchContext.getText();
    }

    public String getAttribute(String attribute) {
        return searchContext.getAttribute(attribute);
    }

    public String getTagName(String tagName) {
        return searchContext.getTagName();
    }

    public void sendText(String text) {
        searchContext.sendKeys(text);
    }


}
