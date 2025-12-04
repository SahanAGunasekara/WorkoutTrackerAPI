package org.example.workouttracker.Repo;

import org.example.workouttracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByEmailAndPassword(String email,String password);
}
