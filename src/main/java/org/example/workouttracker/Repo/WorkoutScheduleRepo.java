package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.Workout_Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutScheduleRepo extends JpaRepository<Workout_Schedule,Integer> {
}
