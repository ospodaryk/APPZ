package com.project.appz.service.impl;

import com.project.appz.entities.Poll;
import com.project.appz.entities.User;
import com.project.appz.enums.Disease;
import com.project.appz.service.StatisticService;
import com.project.appz.utils.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    Logger logger;

    @Override
    public List<Integer> getStatistic(User user, Disease disease) {
        return null;
    }

    @Override
    public List<Integer> getStatistic(User user, Disease disease, Poll poll) {
        return null;
    }

    @Override
    public List<Integer> getStatistic(User user, Disease disease, Poll poll, Date date) {
        return null;
    }
}
