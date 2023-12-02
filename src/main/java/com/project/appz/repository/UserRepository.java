package com.project.appz.repository;

import com.project.appz.entities.ResponsePoll;
import com.project.appz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserRepository extends JpaRepository<User, Long> {

  }
