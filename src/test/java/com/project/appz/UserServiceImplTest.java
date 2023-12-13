package com.project.appz;

import com.project.appz.models.dto.ProfileDto;
import com.project.appz.models.entities.Cabinet;
import com.project.appz.repository.CabinetRepository;
import com.project.appz.repository.UserRepository;
import com.project.appz.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private MedicalRecordServiceImpl medicalRecordService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CabinetRepository cabinetRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void testFindAllWithEmailForInvalidUser() {
        // Setup mock data
        String userEmail = "invalid@example.com";
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        // Assertions
        assertThrows(NoSuchElementException.class, () -> userService.findAll(userEmail));
    }
    @Test
    void testFindAllWithEmailForValidUser() {
        // Setup mock data
        String userEmail = "valid@example.com";
        User user=ModelUtils.getUser();
        user.setEmail(userEmail);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertThrows(NoSuchElementException.class, () -> userService.findAll(userEmail));
    }

    @Test
    void testFindAllWithIdForValidUser() {
        // Setup mock data
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(medicalRecordService.getRecordByPatient(userId)).thenReturn(Collections.emptyList());
        when(cabinetRepository.findByUserId(userId)).thenReturn(ModelUtils.getCabinet()); // Populate with realistic data

        // Call the method
        ProfileDto result = userService.findAll(userId);

        // Assertions
        assertNotNull(result);
        assertEquals(userId, result.getId());
        // More assertions based on expected ProfileDto
    }
    @Test
    void testFindAllWithIdForValidUser2() {
        // Setup mock data
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(medicalRecordService.getRecordByPatient(userId)).thenReturn(Arrays.asList(ModelUtils.getMedicalRecord_ECZEMA(),ModelUtils.getMedicalRecord_ACNE(),ModelUtils.getMedicalRecordLastYear_ACNE()));
        when(cabinetRepository.findByUserId(userId)).thenReturn(ModelUtils.getCabinet()); // Populate with realistic data
        // Call the method
        ProfileDto result = userService.findAll(userId);

        // Assertions
        assertNotNull(result);
        assertEquals(userId, result.getId());
        // More assertions based on expected ProfileDto
    }
    @Test
    void testFindAllWithIdForInvalidUser() {
        // Setup mock data
        Long userId = 99L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Assertions
        assertThrows(NoSuchElementException.class, () -> userService.findAll(userId));
    }

}
