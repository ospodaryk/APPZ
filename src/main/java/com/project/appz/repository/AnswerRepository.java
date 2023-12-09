package com.project.appz.repository;

import com.project.appz.models.entities.Answer;
import com.project.appz.models.entities.AssignedPoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
