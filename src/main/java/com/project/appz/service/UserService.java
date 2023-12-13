package com.project.appz.service;

import com.project.appz.models.dto.ProfileDto;

public interface UserService {
    ProfileDto findAll(Long userId);

    ProfileDto findAll(String userId);
}
