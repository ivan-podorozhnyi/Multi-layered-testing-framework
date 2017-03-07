package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;

import java.util.List;


public class DropDownCriteria implements ISpecification {
    private DropDown dropDown;
    private Specification specification;

    public DropDownCriteria(DropDown dropDown, Specification specification) {
        this.dropDown = dropDown;
        this.specification = specification;
    }

    public static DropDownCriteria get(DropDown dropDown, Specification specification) {
        return new DropDownCriteria(dropDown, specification);
    }

    public DropDownCriteria valueIsMatched(String option) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = option.equals(dropDown.getSelectedOption());
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append(ErrorConstants.EXPECTED);
            appendError.append(dropDown.getSelectedOption());
            appendError.append(ErrorConstants.ACTUAL);
            appendError.append(option);
        }
        specification.add(isMatch, appendError.toString());
        return this;
    }

    public DropDownCriteria valuesAreMatched(List<String> options) {
        StringBuilder appendError = new StringBuilder();
        boolean isMatch = (dropDown.getAllOptions().containsAll(options) && (options
                .containsAll(dropDown.getAllOptions())));
        if (!isMatch) {
            appendError.append(ErrorConstants.MISMATCH);
            appendError.append("Wrong options");
        }
        specification.add(isMatch, appendError.toString());
        return this;

    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
