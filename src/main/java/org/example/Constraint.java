package org.example;

public class Constraint {
    private final String constraint;
    private final Double probability;

    public Constraint(String constraint, double probability) {
        this.constraint = constraint;
        this.probability = probability;
    }

    public Double getProbability() {
        return probability;
    }

    public String getConstraint() {
        return constraint;
    }
}
