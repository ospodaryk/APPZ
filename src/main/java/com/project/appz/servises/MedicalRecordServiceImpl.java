package com.project.appz.servises;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.interfaces.IMedicalRecordService;
import com.project.appz.repository.MedicalRecordRepository;

import java.util.List;

public class MedicalRecordServiceImpl implements IMedicalRecordService {
    MedicalRecordRepository recordRepository;

    @Override
    public void createRecord(MedicalRecord record) {
        recordRepository.save(record);
    }

    @Override
    public void updateRecord(MedicalRecord record) {
        //check if exist
//        recordRepository.save(record);
    }

    @Override
    public MedicalRecord getRecordByPatient(User patient) {
        // Implementation to retrieve a medical record by patient
        //check if user exist
//        return recordRepository.findByUser(patient);
        return null;
    }

    @Override
    public List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease) {
        // Implementation to retrieve a medical record by patient
        //check if user and  disease exist
//        return recordRepository.findByUserAndDisease(patient);
        return null;
    }
}
