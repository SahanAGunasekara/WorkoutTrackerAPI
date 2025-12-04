package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise,Integer> {
}
