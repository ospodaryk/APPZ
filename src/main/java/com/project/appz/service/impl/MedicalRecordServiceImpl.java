package com.project.appz.service.impl;

import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;
import com.project.appz.repository.MedicalRecordRepository;
import com.project.appz.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    MedicalRecordRepository recordRepository;

    @Autowired
    public MedicalRecordServiceImpl(MedicalRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public void createRecord(MedicalRecord record) {
        if (record == null) {
            throw new NullPointerException("MedicalRecord can not be null to save");
        }
        recordRepository.save(record);
    }

    @Override
    public void updateRecord(MedicalRecord record) {
        if (record == null) {
            throw new NullPointerException("MedicalRecord can not be null to update");
        }
        recordRepository.save(record);
    }

    @Override
    public List<MedicalRecord> getRecordByPatient(Long userId) {
        return recordRepository.findByPatientId(userId);
    }

    @Override
    public MedicalRecord findById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("MedicalRecord not found with ID: " + id));
    }

    @Override
    public List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease) {
        if (patient == null || disease == null) {
            throw new NullPointerException("MedicalRecord not found with patient :" + patient.getName() + " and disease: " + disease);
        }
        return recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName());
    }

    @Override
    public List<MedicalRecord> sortByDate(User patient, Disease disease) {
        return getRecordByDiseaseAndPatient(patient, disease)
                .stream()
                .sorted(Comparator.comparing(MedicalRecord::getCreatedTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecord> sortByDate(User patient) {
        return getRecordByPatient(patient.getId())
                .stream()
                .sorted(Comparator.comparing(MedicalRecord::getCreatedTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecord> sortByDisease(User patient) {
        return getRecordByPatient(patient.getId())
                .stream()
                .sorted(Comparator.comparing(MedicalRecord::getDisease))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecord> filterByDisease(Long patient, String disease) {
        return getRecordByPatient(patient)
                .stream()
                .filter(obj -> obj.getDisease().equals(disease))
                .collect(Collectors.toList());
    }
}
