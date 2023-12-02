package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    @Column(name = "name" )
    private String name;

  
    @Column(name = "surname" )
    private String surname;
    @Column(name = "phone_number" )
    private String phoneNumber;


    @Column(name = "email" )
    private String email;


    @OneToMany
    private List<MedicalRecord> medicalRecords = new ArrayList<>();


    @Pattern(regexp = ".*\\d.*", message = "Must contain at least one digit")
    @Pattern(regexp = ".*[A-Z].*", message = "Must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*", message = "Must contain at least one lowercase letter")
    @Column(name = "password" )
    private String password;

    public void updateContactInfo(String phoneNumber, String email) {
        // Implementation
    }

    public String getFullName() {
        // Implementation
        return name + " " + surname;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
