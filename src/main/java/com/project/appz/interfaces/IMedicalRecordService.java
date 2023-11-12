package com.project.appz.interfaces;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMedicalRecordService {
    void createRecord(MedicalRecord record);

    void updateRecord(MedicalRecord record);

    MedicalRecord getRecordByPatient(User patient);

    List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease);
}
