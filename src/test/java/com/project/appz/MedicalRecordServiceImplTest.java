package com.project.appz;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.interfaces.IMedicalRecordService;
import com.project.appz.repository.MedicalRecordRepository;
import com.project.appz.servises.MedicalRecordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceImplTest {
    @InjectMocks
    private MedicalRecordServiceImpl service;
    @Mock
    private MedicalRecordRepository recordRepository;

    @Test
    void createRecord_ValidRecord_CallsSave() {
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        service.createRecord(record);
        verify(recordRepository).save(record);
    }

    @Test
    void createRecord_NullRecord_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.createRecord(null));
    }

    @Test
    void updateRecord_ValidRecord_CallsSave() {
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        record.setRecordId(2L);
        service.updateRecord(record);
        verify(recordRepository).save(record);
    }

    @Test
    void updateRecord_NullRecord_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateRecord(null));
    }

    @Test
    void getRecordByPatient_ValidPatient_ReturnsRecord() {
        User patient = ModelUtils.getUser();
        MedicalRecord expectedRecord = new MedicalRecord();
        Mockito.when(recordRepository.findByUser(patient)).thenReturn(Arrays.asList(expectedRecord));
        MedicalRecord result = service.getRecordByPatient(patient);
        assertEquals(expectedRecord, result);
    }

    @Test
    void getRecordByPatient_NullPatient_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.getRecordByPatient(null));
    }

    @Test
    void getRecordByDiseaseAndPatient_ValidInputs_ReturnsRecords() {
        User patient = ModelUtils.getUser();
        Disease disease = Disease.ACNE;
        List<MedicalRecord> expectedRecords = Arrays.asList(ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        patient.setMedicalRecords(Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE()));
        Mockito.when(recordRepository.findByUserAndDisease(patient, disease)).thenReturn(expectedRecords);

        List<MedicalRecord> result = service.getRecordByDiseaseAndPatient(patient, disease);
        assertEquals(expectedRecords, result);
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputs_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.getRecordByDiseaseAndPatient(null, null));
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputUser_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.getRecordByDiseaseAndPatient(null, Disease.ACNE));
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputDisese_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.getRecordByDiseaseAndPatient(ModelUtils.getUser(), null));
    }
}
