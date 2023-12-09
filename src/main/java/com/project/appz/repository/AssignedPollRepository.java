package com.project.appz.repository;

import com.project.appz.models.entities.AssignedPoll;
import com.project.appz.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedPollRepository extends JpaRepository<AssignedPoll, Long> {
    public AssignedPoll findByPollId(Long pollId);

}
