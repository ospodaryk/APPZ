package com.project.appz.repository;

import com.project.appz.models.Statistic;

import java.util.Date;
import java.util.List;

public interface StatisticRepository {
    List<Statistic> findByBlockAndDateRange(String block, Date startDate, Date endDate);
}
