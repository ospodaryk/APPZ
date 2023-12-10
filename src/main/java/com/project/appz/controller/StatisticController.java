package com.project.appz.controller;

import com.project.appz.models.dto.LongMedicalRecordDto;
import com.project.appz.models.dto.ShortMedicalRecordDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.MedicalRecord;
import com.project.appz.models.entities.Statistic;
import com.project.appz.service.MedicalRecordService;
import com.project.appz.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{blockId}")
    @ResponseBody
    public StatisticDto filterMedicalRecordForUserbyDisease(@PathVariable Long blockId, @RequestParam(name = "userId") long userId) {
        return statisticService.filterByBlock(userId, blockId);
    }
}
