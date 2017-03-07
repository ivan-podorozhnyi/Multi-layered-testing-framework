package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;


public class ControlWrapperSelect {
    private WebElement searchContext;
    private Select select;

    public ControlWrapperSelect(WebElement searchContext) {
        this.searchContext = searchContext;
        select = new Select(searchContext);
    }

    public WebElement get() {
        return searchContext;
    }

   public void selectOptionByText(String option)
   {
       select.selectByVisibleText(option);

   }

   public void selectOptionByValue(String value){
        select.selectByValue(value);
   }

   public void selectOptionByVisibleText(String text){
       select.selectByVisibleText(text);
   }

   public void selectOptionByIndex(int index){
       select.selectByIndex(index);
   }

   public String getSelectedOption(){
      return select.getFirstSelectedOption().getText();
   }

   public boolean isDisplayed(){
       return searchContext.isDisplayed();
   }

   public List<String> getAllOptions(){
       List<String> allOptions;

       List options = select.getOptions();
       for (Object option : options){
          options.add(option.toString());
       }
       return options;
   }


}
