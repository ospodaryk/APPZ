package com.project.appz.service;

import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;

import java.util.List;

public interface MedicalRecordService {
    void createRecord(MedicalRecord record);

    void updateRecord(MedicalRecord record);

    List<MedicalRecord> getRecordByPatient(Long userId);
    List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient);

    public List<MedicalRecord> sortByDisease(User patient);
}
