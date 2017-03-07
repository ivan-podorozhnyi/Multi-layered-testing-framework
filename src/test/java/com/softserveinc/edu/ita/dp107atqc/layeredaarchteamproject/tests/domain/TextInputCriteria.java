package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.TextInput;



public class TextInputCriteria implements ISpecification {
    private TextInput textInput;
    private Specification specification;

    private TextInputCriteria(TextInput textInput, Specification specification) {
        this.textInput = textInput;
        this.specification = specification;
    }

    public static TextInputCriteria get(TextInput textInput, Specification specification) {
        return new TextInputCriteria(textInput, specification);
    }

    public TextInputCriteria valueMatch(String expectedResult) {
        this.specification.add(this.textInput.getValue().equals(expectedResult),
                "Values doesn't match.");
        return this;
    }

    public TextInputCriteria isVisible() {
        this.specification.add(this.textInput.isDisplayed(), "It's not visible.");
        return this;
    }

    public Specification next() {
        return this.specification;
    }

}
