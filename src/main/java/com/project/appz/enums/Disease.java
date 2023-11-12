package com.project.appz.enums;

public enum Disease {
    COMMON_COLD("Common Cold"),
    FLU("Influenza"),
    BRONCHITIS("Bronchitis"),
    GASTROENTERITIS("Gastroenteritis"),
    TONSILLITIS("Tonsillitis"),
    SINUSITIS("Sinusitis"),
    ALLERGIES("Allergies"),
    ASTHMA("Asthma"),
    DIARRHEA("Diarrhea"),
    CONSTIPATION("Constipation"),
    HEADACHE("Headache"),
    DERMATITIS("Dermatitis"),
    ACNE("Acne"),
    ECZEMA("Eczema"),
    LARYNGITIS("Laryngitis"),
    OTITIS_MEDIA("Otitis Media"),
    STREP_THROAT("Strep Throat"),
    URINARY_TRACT_INFECTION("Urinary Tract Infection"),
    CHICKEN_POX("Chicken Pox"),
    MEASLES("Measles"),
    DIABETES("Diabetes"),
    HYPERTENSION("Hypertension"),
    CANCER("Cancer"),
    ALZHEIMERS("Alzheimer's Disease"),
    ARTHRITIS("Arthritis"),
    OSTEOPOROSIS("Osteoporosis"),
    MIGRAINE("Migraine"),
    TUBERCULOSIS("Tuberculosis"),
    HIV_AIDS("HIV/AIDS");

    private final String displayName;

    Disease(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
