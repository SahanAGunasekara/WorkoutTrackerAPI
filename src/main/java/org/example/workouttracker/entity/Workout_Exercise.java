package org.example.workouttracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Workout_Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    @Column(name = "weight")
    private double weight;

    @Column(name = "duration")
    private int duration;

    @Column(name = "order_number")
    private int orderNo;
}
