package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

public class LinkCriteria implements ISpecification {
    private Link link;
    private Specification specification;

    private LinkCriteria(Link link, Specification specification) {
        this.link = link;
        this.specification = specification;
    }

    public static LinkCriteria get(Link link, Specification specification) {
        return new LinkCriteria(link, specification);
    }

    public LinkCriteria valueMatch(String expectedResult) {
        this.specification.add(this.link.getText().equals(expectedResult),
            "Values doesn't match.");
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
