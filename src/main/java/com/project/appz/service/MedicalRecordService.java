package com.project.appz.service;

import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;

import java.util.List;

public interface MedicalRecordService {
    public void createRecord(MedicalRecord record);

    public void updateRecord(MedicalRecord record);

    public List<MedicalRecord> getRecordByPatient(Long userId);

    public List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient, Disease disease);

    public List<MedicalRecord> sortByDate(User patient);

    public List<MedicalRecord> sortByDisease(User patient);

    public List<MedicalRecord> filterByDisease(Long patient, String disease);

    public MedicalRecord findById(Long id);
}
