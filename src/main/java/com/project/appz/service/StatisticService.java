package com.project.appz.service;

import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.Statistic;

public interface StatisticService {
    StatisticDto filterByPoll(Long statisticId);

    public void saveData(ResponseDto responseDto);

    StatisticDto filterByBlock(Long patient, Long blockId);

    public StatisticDto filterByBlockAndPoll(Long patient, Long pollId, Long blockId);

    Statistic findById(Long statisticId);
}
