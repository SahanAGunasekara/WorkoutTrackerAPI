package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.Status;
import org.example.workouttracker.entity.User;
import org.example.workouttracker.entity.Workout;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepo extends JpaRepository<Workout,Integer> {
    List<Workout> findByTitleAndStatus(String title, Status status);
    List<Workout> findByTitleAndUser(String title, User user);
    List<Workout> findByStatusAndUser(Status status,User user,Sort sort);
}
