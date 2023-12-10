package com.project.appz.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private MedicalRecordService medicalRecordService;
    private UserRepository userRepository;
    private CabinetRepository cabinetRepository;

    @Autowired

    public ProfileController(MedicalRecordService medicalRecordService, UserRepository userRepository, CabinetRepository cabinetRepository) {
        this.medicalRecordService = medicalRecordService;
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
    }


    @GetMapping
    @ResponseBody
    public ProfileDto getProfileDto(@RequestParam(name = "userId") long userId) {
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
        return profileDto;
    }

}
