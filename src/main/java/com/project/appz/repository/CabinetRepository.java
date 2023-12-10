package com.project.appz.repository;

import com.project.appz.models.entities.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
    Cabinet findByUserId(Long user);
}
