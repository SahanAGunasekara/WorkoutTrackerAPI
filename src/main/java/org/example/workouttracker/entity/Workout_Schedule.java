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
public class Workout_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Column(name = "schedule_date")
    private Date Schedule_date;

    @Column(name = "schedule_time")
    private Date Schedule_time;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
