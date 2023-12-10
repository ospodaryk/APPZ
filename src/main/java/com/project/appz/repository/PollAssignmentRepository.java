package com.project.appz.repository;

import com.project.appz.models.entities.PollAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollAssignmentRepository extends JpaRepository<PollAssignment, Long> {
    @Query(value = "SELECT id, created_date, deadline, is_completed, doctor_id, poll_id, user_id\n" +
            "FROM public.poll_assignment\n" +
            "WHERE user_id = :userId AND is_completed = true", nativeQuery = true)
    public List<PollAssignment> findByUserIdAndIsCompleted(@Param("userId") Long userId);

    @Query(value = "SELECT id, created_date, deadline, is_completed, doctor_id, poll_id, user_id " +
            "FROM public.poll_assignment " +
            "WHERE user_id = :userId AND poll_id = :pollId", nativeQuery = true)
    public PollAssignment findByPollIdAndUserId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    @Query(value = "SELECT id, created_date, deadline, is_completed, doctor_id, poll_id, user_id\n" +
            "FROM public.poll_assignment\n" +
            "WHERE user_id = :userId AND is_completed = false", nativeQuery = true)
    public List<PollAssignment> findByUserId(@Param("userId") Long user);

}
