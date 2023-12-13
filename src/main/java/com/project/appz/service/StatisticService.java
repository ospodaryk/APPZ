package com.project.appz.service;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Statistic;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    StatisticDto filterByPoll(Long statisticId);

    public void saveData(ResponseDto responseDto);

    StatisticDto filterByBlock(Long patient, Long blockId);

    public StatisticDto filterByBlockAndPoll(Long patient, Long pollId, Long blockId);

    Statistic findById(Long statisticId);
}
