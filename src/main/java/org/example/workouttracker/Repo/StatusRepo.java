package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status,Integer> {
}
