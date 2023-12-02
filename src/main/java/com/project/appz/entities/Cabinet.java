package com.project.appz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cabinet")
public class Cabinet {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "disease", nullable = false)
    private String disease;


    // Метод для управління взаємодією між лікарем та користувачем
    public void managePollAppointment() {
        // Логіка для управління взаємодією
        // Наприклад, назначити зустріч, відправити повідомлення тощо
    }


    // Методи для доступу та зміни стану лікаря або користувача
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        // Додаткова логіка, якщо необхідно
    }


    public void setUser(User user) {
        this.user = user;
        // Додаткова логіка, якщо необхідно
    }


    // ... Інші методи, які можуть знадобитися для управління взаємодією
}
