package com.project.appz;

import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;
import com.project.appz.repository.MedicalRecordRepository;
import com.project.appz.service.impl.MedicalRecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceImplTest {
    @InjectMocks
    private MedicalRecordServiceImpl service;
    @Mock
    private MedicalRecordRepository recordRepository;

    @Test
    void finById() {
        Mockito.when(recordRepository.findById(any())).thenReturn(Optional.of(ModelUtils.getMedicalRecord_ACNE()));
        MedicalRecord medicalRecord = service.findById(1L);
        assertEquals(medicalRecord.getId(), ModelUtils.getMedicalRecord_ACNE().getId());
        verify(recordRepository).findById(1L);
    }

    @Test
    void finByI_error() {
        assertThrows(NullPointerException.class, () -> service.findById(1L));
        verify(recordRepository).findById(1L);
    }

    @Test
    void createRecord_ValidRecord_CallsSave() {
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        service.createRecord(record);
        verify(recordRepository).save(record);
    }

    @Test
    void createRecord_NullRecord_ThrowsException() {
        assertThrows(NullPointerException.class, () -> service.createRecord(null));
    }

    @Test
    void updateRecord_ValidRecord_CallsSave() {
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        record.setId(2L);
        service.updateRecord(record);
        verify(recordRepository).save(record);
    }

    @Test
    void updateRecord_NullRecord_ThrowsException() {
        assertThrows(NullPointerException.class, () -> service.updateRecord(null));
    }

    @Test
    void getRecordByPatient_ValidPatient_ReturnsRecord() {
        User patient = ModelUtils.getUser();
        patient.setMedicalRecords(Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE()));

        List<MedicalRecord> expectedRecords = Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(expectedRecords);
        List<MedicalRecord> result = service.getRecordByPatient(patient.getId());
        assertEquals(expectedRecords, result);
    }

    @Test
    void filterByDisease() {
        User patient = ModelUtils.getUser();
        patient.setMedicalRecords(Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE()));
        List<MedicalRecord> expectedRecords = Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(expectedRecords);
        List<MedicalRecord> result = service.filterByDisease(patient.getId(), Disease.ACNE.getDisplayName());
        assertEquals(2, result.size());
    }

    @Test
    void getRecordByDiseaseAndPatient_ValidInputs_ReturnsRecords() {
        User patient = ModelUtils.getUser();
        Disease disease = Disease.ACNE;
        List<MedicalRecord> expectedRecords = Arrays.asList(ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        patient.setMedicalRecords(Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(), ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE()));
        Mockito.when(recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName())).thenReturn(expectedRecords);

        List<MedicalRecord> result = service.getRecordByDiseaseAndPatient(patient, disease);
        assertEquals(expectedRecords, result);
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputs_ThrowsException() {
        assertThrows(NullPointerException.class, () -> service.getRecordByDiseaseAndPatient(null, null));
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputUser_ThrowsException() {
        assertThrows(NullPointerException.class, () -> service.getRecordByDiseaseAndPatient(null, Disease.ACNE));
    }

    @Test
    void getRecordByDiseaseAndPatient_NullInputDisese_ThrowsException() {
        assertThrows(NullPointerException.class, () -> service.getRecordByDiseaseAndPatient(ModelUtils.getUser(), null));
    }

    @Test
    void sortByDate_ValidPatientAndDisease_SortsRecordsByDate() {
        User patient = ModelUtils.getUser();
        Disease disease = Disease.ACNE;
        List<MedicalRecord> unsortedRecords = Arrays.asList(ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        Mockito.when(recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName())).thenReturn(unsortedRecords);

        List<MedicalRecord> sortedRecords = service.sortByDate(patient, disease);
        assertFalse(sortedRecords.isEmpty());
        assertTrue(sortedRecords.get(0).getCreatedTime().isBefore(sortedRecords.get(1).getCreatedTime()));
    }

    @Test
    void sortByDate_ValidPatient_SortsRecordsByDate() {
        User patient = ModelUtils.getUser();
        List<MedicalRecord> unsortedRecords = Arrays.asList(ModelUtils.getMedicalRecordLastYear_ACNE(), ModelUtils.getMedicalRecord_ACNE());
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(unsortedRecords);

        List<MedicalRecord> sortedRecords = service.sortByDate(patient);
        assertFalse(sortedRecords.isEmpty());
        assertTrue(sortedRecords.get(0).getCreatedTime().isBefore(sortedRecords.get(1).getCreatedTime()));
    }

    @Test
    void sortByDisease_ValidPatient_SortsRecordsByDisease() {
        User patient = ModelUtils.getUser();
        List<MedicalRecord> unsortedRecords = Arrays.asList(ModelUtils.getMedicalRecord_ACNE(), ModelUtils.getMedicalRecord_ECZEMA());
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(unsortedRecords);

        List<MedicalRecord> sortedRecords = service.sortByDisease(patient);
        assertFalse(sortedRecords.isEmpty());
        assertTrue(sortedRecords.get(0).getDisease().compareTo(sortedRecords.get(1).getDisease()) <= 0);
    }

    @Test
    void sortByDate_PatientDiseaseEmptyList_ReturnsEmptyList() {
        User patient = ModelUtils.getUser();
        Disease disease = Disease.ACNE;
        Mockito.when(recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName())).thenReturn(Collections.emptyList());

        List<MedicalRecord> sortedRecords = service.sortByDate(patient, disease);
        assertTrue(sortedRecords.isEmpty());
    }

    @Test
    void sortByDate_PatientDiseaseSingleRecord_ReturnsSingleRecord() {
        User patient = ModelUtils.getUser();
        Disease disease = Disease.ACNE;
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        Mockito.when(recordRepository.findByPatientIdAndDiseaseLike(patient.getId(), disease.getDisplayName())).thenReturn(Collections.singletonList(record));

        List<MedicalRecord> sortedRecords = service.sortByDate(patient, disease);
        assertEquals(1, sortedRecords.size());
        assertEquals(record, sortedRecords.get(0));
    }

    @Test
    void sortByDate_PatientEmptyList_ReturnsEmptyList() {
        User patient = ModelUtils.getUser();
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(Collections.emptyList());

        List<MedicalRecord> sortedRecords = service.sortByDate(patient);
        assertTrue(sortedRecords.isEmpty());
    }

    @Test
    void sortByDate_PatientSingleRecord_ReturnsSingleRecord() {
        User patient = ModelUtils.getUser();
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(Collections.singletonList(record));

        List<MedicalRecord> sortedRecords = service.sortByDate(patient);
        assertEquals(1, sortedRecords.size());
        assertEquals(record, sortedRecords.get(0));
    }

    @Test
    void sortByDisease_PatientEmptyList_ReturnsEmptyList() {
        User patient = ModelUtils.getUser();
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(Collections.emptyList());

        List<MedicalRecord> sortedRecords = service.sortByDisease(patient);
        assertTrue(sortedRecords.isEmpty());
    }

    @Test
    void sortByDisease_PatientSingleRecord_ReturnsSingleRecord() {
        User patient = ModelUtils.getUser();
        MedicalRecord record = ModelUtils.getMedicalRecord_ACNE();
        Mockito.when(recordRepository.findByPatientId(patient.getId())).thenReturn(Collections.singletonList(record));

        List<MedicalRecord> sortedRecords = service.sortByDisease(patient);
        assertEquals(1, sortedRecords.size());
        assertEquals(record, sortedRecords.get(0));
    }
}
