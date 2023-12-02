package com.project.appz.repository;

import com.project.appz.models.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatientId(Long user);

    List<MedicalRecord> findByPatientIdAndDiseaseLike(Long user, String disease);
}
