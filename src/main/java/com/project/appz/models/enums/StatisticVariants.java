package com.project.appz.models.enums;

public enum StatisticVariants {
    GOOD("Хороші показники"),
    BAD("Погані показники");

    private final String displayName;

    StatisticVariants(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
