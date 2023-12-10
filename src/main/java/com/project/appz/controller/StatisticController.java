package com.project.appz.controller;

import com.project.appz.models.dto.LongMedicalRecordDto;
import com.project.appz.models.dto.ShortMedicalRecordDto;
import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private MedicalRecordService medicalRecordService;

    @Autowired
    public StatisticController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    @ResponseBody
    public List<ShortMedicalRecordDto> getAllMedicalRecordForUserById(@RequestParam(name = "userId") long userId) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getRecordByPatient(userId);
        List<ShortMedicalRecordDto> shortMedicalRecordDtos = new ArrayList<>();
        for (int i = 0; i < medicalRecords.size(); i++) {
            shortMedicalRecordDtos.add(ShortMedicalRecordDto
                    .builder()
                    .id(medicalRecords.get(i).getId())
                    .dateofvisit(medicalRecords.get(i).getCreatedTime().toString())
                    .doctorName(medicalRecords.get(i).getDoctor().getName() + " " + medicalRecords.get(i).getDoctor().getSurname())
                    .title(medicalRecords.get(i).getDisease()).build());
        }
        return shortMedicalRecordDtos;
    }

    @GetMapping("/{disease}")
    @ResponseBody
    public List<ShortMedicalRecordDto> filterMedicalRecordForUserbyDisease(@PathVariable String disease, @RequestParam(name = "userId") long userId) {
        List<MedicalRecord> medicalRecords = medicalRecordService.filterByDisease(userId, disease);
        List<ShortMedicalRecordDto> shortMedicalRecordDtos = new ArrayList<>();
        for (int i = 0; i < medicalRecords.size(); i++) {
            shortMedicalRecordDtos.add(ShortMedicalRecordDto
                    .builder()
                    .id(medicalRecords.get(i).getId())
                    .dateofvisit(medicalRecords.get(i).getCreatedTime().toString())
                    .doctorName(medicalRecords.get(i).getDoctor().getName() + " " + medicalRecords.get(i).getDoctor().getSurname())
                    .title(medicalRecords.get(i).getDisease()).build());
        }
        return shortMedicalRecordDtos;
    }

    @GetMapping("/details/{id}")
    @ResponseBody
    public LongMedicalRecordDto getMedicalRecordForUserById(@PathVariable long id, @RequestParam(name = "userId") long userId) {
        MedicalRecord medicalRecord = medicalRecordService.findById(id);
        return LongMedicalRecordDto
                .builder()
                .id(medicalRecord.getId())
                .dateofvisit(medicalRecord.getCreatedTime().toString())
                .doctorName(medicalRecord.getDoctor().getName() + " " + medicalRecord.getDoctor().getSurname())
                .doctorNotes(medicalRecord.getDoctorNotes())
                .title(medicalRecord.getDisease()).build();
    }
}
