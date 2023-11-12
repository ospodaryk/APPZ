package com.project.appz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

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
    @OneToMany
    @JoinColumn(name = "medical_record")
    List<MedicalRecord> medicalRecords;

    public void updateContactInfo(String phoneNumber, String email) {
        // Implementation
    }

    public String getFullName() {
        // Implementation
        return name + " " + surname;
    }
}
