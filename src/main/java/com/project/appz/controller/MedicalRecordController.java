package com.project.appz.controller;

import com.project.appz.models.dto.*;
import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.Poll;
import com.project.appz.service.MedicalRecordService;
import com.project.appz.service.PollManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalrecord")
public class MedicalRecordController {

    private MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    @ResponseBody
    public List<ShortMedicalRecordDto> getMedicalRecordForUserById(@RequestParam(name = "userId") long userId) {
       List<MedicalRecord> medicalRecords=medicalRecordService.getRecordByPatient(userId);
      List<ShortMedicalRecordDto> shortMedicalRecordDtos=new ArrayList<>();
        for (int i = 0; i < medicalRecords.size(); i++) {
            shortMedicalRecordDtos.add(ShortMedicalRecordDto.builder()
                            .id(medicalRecords.get(i).getId())
                            .dateofvisit(medicalRecords.get(i).getCreatedTime().toString())
                            .doctorName(medicalRecords.get(i).getDoctor().getName()+" "+medicalRecords.get(i).getDoctor().getSurname())
                            .title(medicalRecords.get(i).getDisease())
                    .build());
        }
        return shortMedicalRecordDtos;
    }

    @PostMapping("/response")
    public ResponseEntity<Void> submitResponse(@RequestBody ResponseDto responseDto) {
//        pollManager.savePollResults(responseDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
