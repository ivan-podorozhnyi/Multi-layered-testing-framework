package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain;

public class BooleanCriteria implements ISpecification {
    private Specification specification;
    private Boolean result;
    
    private BooleanCriteria(Boolean result, Specification specification) {
        this.result = result;
        this.specification = specification;
    }
    
    public static BooleanCriteria get(Boolean result, Specification specification) {
        return new BooleanCriteria(result, specification);
    }
    
    public BooleanCriteria valueMatch(Boolean expectedResult) {
        this.specification.add(this.result.equals(expectedResult),
                "Values doesn't match.");
        return this;
    }
    
    @Override
    public Specification next() {
        return this.specification;
    }
}
