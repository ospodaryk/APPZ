package com.project.appz.models.enums;

public enum Specialization {
    CARDIOLOGY("Cardiology"),
    DERMATOLOGY("Dermatology"),
    NEUROLOGY("Neurology"),
    PEDIATRICS("Pediatrics"),
    ONCOLOGY("Oncology"),
    PSYCHIATRY("Psychiatry"),
    GENERAL_MEDICINE("General Medicine"),
    ORTHOPEDICS("Orthopedics"),
    GASTROENTEROLOGY("Gastroenterology"),
    ENDOCRINOLOGY("Endocrinology");

    private final String displayName;

    Specialization(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
