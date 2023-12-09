package com.project.appz.service;

import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    List<Integer> getStatistic(User user, Disease disease);

    List<Integer> getStatistic(User user, Disease disease, Poll poll);

    List<Integer> getStatistic(User user, Disease disease, Poll poll, Date date);
}
