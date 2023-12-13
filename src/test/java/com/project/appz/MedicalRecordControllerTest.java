package com.project.appz;
import com.project.appz.controller.MedicalRecordController;
import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.service.MedicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

class MedicalRecordControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MedicalRecordService medicalRecordService;

    @InjectMocks
    private MedicalRecordController medicalRecordController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(medicalRecordController).build();
    }

    @Test
    void testGetAllMedicalRecordForUserById() throws Exception {
        long userId = 1L;
                when(medicalRecordService.getRecordByPatient(userId)).thenReturn(Arrays.asList(ModelUtils.getMedicalRecord_ACNE(),ModelUtils.getMedicalRecordLastYear_ACNE(),ModelUtils.getMedicalRecord_ECZEMA()));

        mockMvc.perform(get("/medicalrecord")
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists()); // Additional JSON path checks as needed

        verify(medicalRecordService).getRecordByPatient(userId);
    }
    @Test
    void testFilterMedicalRecordForUserbyDisease() throws Exception {
        long userId = 1L;
        String disease = "exampleDisease";
        when(medicalRecordService.getRecordByPatient(userId)).thenReturn(Arrays.asList(ModelUtils.getMedicalRecord_ACNE(),ModelUtils.getMedicalRecordLastYear_ACNE(),ModelUtils.getMedicalRecord_ECZEMA()));

        mockMvc.perform(get("/medicalrecord/" + disease)
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().isOk());

        verify(medicalRecordService).filterByDisease(userId, disease);
    }
}
