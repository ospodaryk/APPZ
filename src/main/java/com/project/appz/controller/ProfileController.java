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
import com.project.appz.service.UserService;
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
    private UserService userService;
    @Autowired

    public ProfileController(MedicalRecordService medicalRecordService, UserRepository userRepository, CabinetRepository cabinetRepository, UserService userService) {
        this.medicalRecordService = medicalRecordService;
        this.userRepository = userRepository;
        this.cabinetRepository = cabinetRepository;
        this.userService = userService;
    }



    @GetMapping
    @ResponseBody
    public ProfileDto getProfileDto(@RequestParam(name = "userId") long userId) {
        return userService.findAll(userId);
    }

}
