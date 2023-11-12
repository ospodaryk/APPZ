package com.project.appz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    @OneToMany
    @JoinColumn(name = "medical_record")
    List<MedicalRecord> medicalRecords;
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

    public void updateContactInfo(String phoneNumber, String email) {
        // Implementation
    }

    public String getFullName() {
        // Implementation
        return name + " " + surname;
    }
}
