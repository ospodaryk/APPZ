package com.project.appz.service;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;

import java.util.List;

public interface MedicalRecordService {
    void createRecord(MedicalRecord record);

    void updateRecord(MedicalRecord record);

    List<MedicalRecord> getRecordByPatient(User patient);

    List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient);

    public List<MedicalRecord> sortByDisease(User patient);
}
