package com.project.appz.repository;

import com.project.appz.models.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    List<Statistic> findByUserId(Long user);

    Statistic findByUserIdAndPollId(Long user, Long pollId);

}
