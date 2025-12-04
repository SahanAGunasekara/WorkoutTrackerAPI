package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.Workout;
import org.example.workouttracker.entity.Workout_Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutExerciseRepo extends JpaRepository<Workout_Exercise,Integer> {
    List<Workout_Exercise> findByWorkout(Workout workout);
}
