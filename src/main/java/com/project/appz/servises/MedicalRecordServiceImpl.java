package com.project.appz.servises;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.interfaces.IMedicalRecordService;
import com.project.appz.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements IMedicalRecordService {
    MedicalRecordRepository recordRepository;

    @Override
    public void createRecord(MedicalRecord record) {
        if(record==null){
            throw new IllegalArgumentException();
        }
        recordRepository.save(record);
    }

    @Override
    public void updateRecord(MedicalRecord record) {
        if(record==null){
            throw new IllegalArgumentException();
        }
        //check if exist
//        recordRepository.save(record);
    }

    @Override
    public MedicalRecord getRecordByPatient(User patient) {
        if(patient==null){
            throw new IllegalArgumentException();
        }
        // Implementation to retrieve a medical record by patient
        //check if user exist
//        return recordRepository.findByUser(patient);
        return null;
    }

    @Override
    public List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease) {
        if(patient==null||disease==null){
            throw new IllegalArgumentException();
        }
        // Implementation to retrieve a medical record by patient
        //check if user and  disease exist
//        return recordRepository.findByUserAndDisease(patient);
        return null;
    }
}
