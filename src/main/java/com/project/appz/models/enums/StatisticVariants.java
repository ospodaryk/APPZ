package com.project.appz.models.enums;

public enum StatisticVariants {
    GOOD("Позитивні (добрі) показники"),
    BAD("Негативні (погані) показники");

    private final String displayName;

    StatisticVariants(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
