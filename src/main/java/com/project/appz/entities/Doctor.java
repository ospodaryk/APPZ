package com.project.appz.entities;

import com.project.appz.enums.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long doctorId;
    @NotBlank
    @Column(name = "specialization")
    Specialization specialization;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "surname")
    private String surname;
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotBlank
    @Column(name = "email")
    private String email;

    public void createPoll(Poll poll) {
        // Implementation
    }

    public MedicalRecord viewPatientRecord(User patient) {
        // Implementation
        return null;
    }

}
