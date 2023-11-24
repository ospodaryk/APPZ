package com.project.appz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "specialization", nullable = false)
    private String specialization;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;


    public void createPoll(Poll poll) {
        // Implementation
    }

    public MedicalRecord viewPatientRecord(User patient) {
        // Implementation
        return null;
    }

}
