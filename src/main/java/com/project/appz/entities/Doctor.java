package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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

  
    @Column(name = "specialization" )
    private String specialization;

  
    @Column(name = "name" )
    private String name;

  
    @Column(name = "surname" )
    private String surname;

  
    @Column(name = "phone_number" )
    private String phoneNumber;

  
    @Column(name = "email" )
    private String email;
    @Pattern(regexp = ".*\\d.*", message = "Must contain at least one digit")
    @Pattern(regexp = ".*[A-Z].*", message = "Must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*", message = "Must contain at least one lowercase letter")
    @Column(name = "password" )
    private String password;

    public void createPoll(Poll poll) {
        // Implementation
    }

    public MedicalRecord viewPatientRecord(User patient) {
        // Implementation
        return null;
    }

}
