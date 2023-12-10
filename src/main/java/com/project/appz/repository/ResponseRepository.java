package com.project.appz.repository;

import com.project.appz.models.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByUserId(Long user);

    List<Response> findByUserIdAndPollId(Long user, Long poll);

}
