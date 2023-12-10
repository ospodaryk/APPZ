package com.project.appz.repository;

import com.project.appz.models.entities.Poll;
import com.project.appz.models.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
