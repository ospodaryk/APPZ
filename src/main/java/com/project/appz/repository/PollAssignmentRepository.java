package com.project.appz.repository;

import com.project.appz.models.entities.PollAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollAssignmentRepository extends JpaRepository<PollAssignment, Long> {
    public PollAssignment findByPollId(Long pollId);

    public List<PollAssignment> findByUserIdAndAndIsCompleted(Long pollId, Boolean check);

}
