package org.example.workouttracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutExerciseDTO {
    private int duration;
    private int orderNumber;
    private int reps;
    private int sets;
    private double weight;
    private int exerciseId;
}
