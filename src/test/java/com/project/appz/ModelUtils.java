package com.project.appz;

import com.project.appz.entities.Doctor;
import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.enums.Specialization;

import java.time.LocalDateTime;
import java.util.Collections;

public  final class ModelUtils {
    public static final User getUser(){
        return User.builder()
                .name("Taras")
                .surname("Shevchenko")
                .phoneNumber("+380979500066")
                .email("sheva@gmail.com")
                .build();
    }
    public static final Doctor getDoctor(){
        return Doctor.builder()
                .name("Taras")
                .specialization(Specialization.DERMATOLOGY)
                .surname("Shevchenko")
                .phoneNumber("+380979500066")
                .email("sheva@gmail.com")
                .build();
    }
    public static final MedicalRecord getMedicalRecord_ACNE(){
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.now())
                .diagnoses(Collections.emptyList())
                .doctorNotes(Collections.emptyList())
                .doctor(getDoctor())
                .disease(Disease.ACNE)
                .patientId(getUser())
                .build();
    }
    public static final MedicalRecord getMedicalRecordLastYear_ACNE(){
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.MAX.minusYears(1))
                .diagnoses(Collections.emptyList())
                .doctorNotes(Collections.emptyList())
                .doctor(getDoctor())
                .disease(Disease.ACNE)
                .patientId(getUser())
                .build();
    }
    public static final MedicalRecord getMedicalRecord_ECZEMA(){
        return MedicalRecord.builder()
                .createdTime(LocalDateTime.MAX.minusYears(1))
                .diagnoses(Collections.emptyList())
                .doctorNotes(Collections.emptyList())
                .doctor(getDoctor())
                .disease(Disease.ECZEMA)
                .patientId(getUser())
                .build();
    }
}
