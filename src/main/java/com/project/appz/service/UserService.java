package com.project.appz.service;

import com.project.appz.models.dto.ProfileDto;
import com.project.appz.models.dto.ResponseDto;
import com.project.appz.models.dto.StatisticDto;
import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.User;
import com.project.appz.models.enums.Disease;

import java.util.Date;
import java.util.List;

public interface UserService {
    ProfileDto findAll(Long userId);
    ProfileDto findAll(String userId);
}
