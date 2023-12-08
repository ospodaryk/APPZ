package com.project.appz.models;

public enum DiagramType {
    TYPE1("Type 1 Diagram"),
    TYPE2("Type 2 Diagram"),
    UNKNOWN("Unknown Diagram");

    private final String description;

    DiagramType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "DiagramType{" +
                "description='" + description + '\'' +
                '}';
    }
}
