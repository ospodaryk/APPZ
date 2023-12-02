package com.project.appz.service;

import com.project.appz.entities.Poll;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    List<Integer> getStatistic(User user, Disease disease);

    List<Integer> getStatistic(User user, Disease disease, Poll poll);

    List<Integer> getStatistic(User user, Disease disease, Poll poll, Date date);
}
