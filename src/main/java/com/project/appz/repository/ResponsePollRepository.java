package com.project.appz.repository;

import com.project.appz.models.entities.ResponsePoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsePollRepository extends JpaRepository<ResponsePoll, Long> {
}
