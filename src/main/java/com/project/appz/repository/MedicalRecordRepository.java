package com.project.appz.repository;

import com.project.appz.entities.MedicalRecord;
import com.project.appz.enums.Disease;
import com.project.appz.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByUser(User user);
    List<MedicalRecord> findByUserAndDisease(User user, Disease disease);
}
