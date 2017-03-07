package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;

public class LabelCriteria implements ISpecification {

    private Label label;
    private Specification specification;

    private LabelCriteria(Label label, Specification specification) {
        this.label = label;
        this.specification = specification;
    }

    public static LabelCriteria get(Label label, Specification specification) {
        return new LabelCriteria(label, specification);
    }

    public LabelCriteria valueIsMatched(String message) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = message.equals(label.getValue());
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append(message);
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append(label.getValue());
        }
        specification.add(isMatch, appendError.toString());
        return  this;

    }

    public LabelCriteria isVisible() {
        StringBuilder appendError = new StringBuilder();
        boolean isVisible = label.isDisplayed();
        if (!isVisible) {
            appendError.append(label.getValue());
            appendError.append(ErrorConstants.NOT_VISIBLE);
        }
        specification.add(isVisible, appendError.toString());
        return this;
    }
    @Override
    public Specification next() {
        return this.specification;
    }
}
