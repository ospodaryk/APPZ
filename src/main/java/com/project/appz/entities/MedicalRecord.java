package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_record")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "created_time" )
    private LocalDateTime createdTime;

    @Column(name = "doctor_notes")
    private String doctorNotes;

    @Column(name = "disease")
    private String disease;

    public void addNote(String note) {
        // Implementation
    }

    public List<String> getDiagnoses() {
        // Implementation
        return new ArrayList<>();
    }
}
