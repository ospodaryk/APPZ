package com.project.appz.service.impl;

import com.project.appz.models.dto.DiseaseDTO;
import com.project.appz.models.dto.DoctorDto;
import com.project.appz.models.dto.ProfileDto;
import com.project.appz.models.dto.ShortMedicalRecordDto;
import com.project.appz.models.entities.Doctor;
import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.User;
import com.project.appz.repository.CabinetRepository;
import com.project.appz.repository.UserRepository;
import com.project.appz.service.MedicalRecordService;
import com.project.appz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    private MedicalRecordService medicalRecordService;
    private UserRepository userRepository;
    private CabinetRepository cabinetRepository;

    @Autowired
    public UserServiceImpl(MedicalRecordService medicalRecordService, UserRepository userRepository, CabinetRepository cabinetRepository) {
        this.medicalRecordService = medicalRecordService;
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public ProfileDto findAll(String userId) {
        LOGGER.log(Level.INFO, "Finding profile for user with email: " + userId);
        User user = userRepository.findAll().stream().filter(obj -> obj.getEmail().equals(userId)).findAny().orElseThrow();
        return findAll(user.getId());
    }

    @Override
    public ProfileDto findAll(Long userId) {
        LOGGER.log(Level.INFO, "Finding profile for user with ID: " + userId);
        List<MedicalRecord> medicalRecords = medicalRecordService.getRecordByPatient(userId);
        List<ShortMedicalRecordDto> shortMedicalRecordDtos = new ArrayList<>();
        ProfileDto profileDto = new ProfileDto();
        User user = userRepository.findById(userId).orElseThrow();
        profileDto.setName(user.getName() + " " + user.getSurname());
        profileDto.setId(userId);
        List<DiseaseDTO> diseaseDTOS = new ArrayList<>();
        for (int i = 0; i < medicalRecords.size(); i++) {
            diseaseDTOS.add(DiseaseDTO.builder()
                    .doctorSpecialisation(medicalRecords.get(i).getDoctor().getSpecialization())
                    .doctorData(medicalRecords.get(i).getDoctor().getName() + " " + medicalRecords.get(i).getDoctor().getSurname())
                    .title(medicalRecords.get(i).getDisease())
                    .build());
        }
        profileDto.setDiseases(diseaseDTOS);
        Doctor doctor = cabinetRepository.findByUserId(userId).getDoctor();
        profileDto.setDoctorDto(DoctorDto.builder()
                .name(doctor.getName() + " " + doctor.getSurname())
                .specialisation(doctor.getSpecialization())
                .build());
        LOGGER.log(Level.INFO, "Profile found successfully for user with ID: " + userId);
        return profileDto;
    }
}
