package org.example.workouttracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title",length = 50,nullable = false)
    private  String title;

    @Column(name = "note",length = 150,nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "created_at",nullable = false)
    private Date created_at;

    @Column(name = "updated_at",nullable = false)
    private Date updatedAt;

    @OneToMany(mappedBy = "workout")
    private List<Workout_Exercise> workout_exercise;
}
