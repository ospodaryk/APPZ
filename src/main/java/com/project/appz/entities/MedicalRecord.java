package com.project.appz.entities;

import com.project.appz.enums.Disease;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MedicalRecord {
    @Id
    @Column(name = "record_id")
    String recordId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    User patientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @Column(name = "created_time")
    LocalDateTime createdTime;

    @ElementCollection
    List<String> doctorNotes;

    @ElementCollection
    List<Disease> diagnoses;

    @Column(name = "disease")
    Disease disease;
    public void addNote(String note) {
        // Implementation
    }

    public List<String> getDiagnoses() {
        // Implementation
        return new ArrayList<>();
    }
}
