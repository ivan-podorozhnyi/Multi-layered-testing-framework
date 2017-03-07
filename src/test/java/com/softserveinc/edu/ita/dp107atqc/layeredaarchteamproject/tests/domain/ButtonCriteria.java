package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;


public class ButtonCriteria implements ISpecification {
    private Button button;
    private Specification specification;

    public ButtonCriteria (Button button, Specification specification) {
        this.button = button;
        this.specification = specification;
    }
    public static ButtonCriteria get(Button button, Specification specification) {
        return new ButtonCriteria(button, specification);
    }

    public ButtonCriteria getName(String name){
        StringBuilder appendError = new StringBuilder();
        boolean isGet = name.equals(button.getText());
        if(!isGet){
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append(name);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append(button.isDisplayed());
        }
        specification.add(isGet, appendError.toString());
        return this;
    }

    public  ButtonCriteria isVisibleButton(){
        StringBuilder appendError = new StringBuilder();
        boolean isVisibleButton = button.isDisplayed();
        if(!isVisibleButton) {
            appendError.append(button.isDisplayed());
            appendError.append(ErrorConstants.NOT_VISIBLE);
        }
        specification.add(isVisibleButton, "Not visible button.");
        return this;

    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
