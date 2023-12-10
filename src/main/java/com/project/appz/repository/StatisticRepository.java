package com.project.appz.repository;

import com.project.appz.models.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    List<Statistic> findByUserId(Long user);

    @Query(value = "SELECT id, result, poll_id, user_id "
            + "FROM public.statistic "
            + "WHERE user_id = :userId AND poll_id = :pollId", nativeQuery = true)
    Statistic findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

}
