package com.project.appz.service.impl;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.repository.MedicalRecordRepository;
import com.project.appz.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    MedicalRecordRepository recordRepository;

    @Override
    public void createRecord(MedicalRecord record) {
        if (record == null) {
            throw new IllegalArgumentException();
        }
        recordRepository.save(record);
    }

    @Override
    public void updateRecord(MedicalRecord record) {
        if (record == null) {
            throw new IllegalArgumentException();
        }
        recordRepository.save(record);
    }

    @Override
    public List<MedicalRecord> getRecordByPatient(User patient) {
        if (patient == null) {
            throw new IllegalArgumentException();
        }
        return recordRepository.findByPatientId(patient.getId());
    }

    @Override
    public List<MedicalRecord> getRecordByDiseaseAndPatient(User patient, Disease disease) {
        if (patient == null || disease == null) {
            throw new IllegalArgumentException();
        }
        return recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName());
    }

    @Override
    public List<MedicalRecord> sortByDate(User patient, Disease disease) {
        return getRecordByDiseaseAndPatient(patient, disease).stream()
                .sorted(Comparator.comparing(MedicalRecord::getCreatedTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecord> sortByDate(User patient) {
        return getRecordByPatient(patient).stream()
                .sorted(Comparator.comparing(MedicalRecord::getCreatedTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalRecord> sortByDisease(User patient) {
        return getRecordByPatient(patient)
                .stream()
                .sorted(Comparator.comparing(MedicalRecord::getDisease))
                .collect(Collectors.toList());
    }
}
