package org.example.workouttracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 45,nullable = false)
    private String name;

    @Column(name = "email",length = 100,nullable = false)
    private String email;

    @Column(name = "password",length = 8,nullable = false)
    private  String password;

    @Column(name = "created_at")
    private Date created_at;
}
