package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.AlertPage;


public class AlertCriteria implements ISpecification {
    private AlertPage alert;
    private Specification specification;
    public AlertCriteria (AlertPage alert, Specification specification) {
        this.alert = alert;
        this.specification = specification;
    }
    public static AlertCriteria get(AlertPage alert, Specification specification) {
        return new AlertCriteria(alert, specification);
    }
    public AlertCriteria compareText(String expectedResult){
        this.specification.add(this.alert.getText().equals(expectedResult), "the text of the " +
                "alert doesn't match");
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
