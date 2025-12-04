package org.example.workouttracker.service;

import org.example.workouttracker.Repo.StatusRepo;
import org.example.workouttracker.Repo.WorkoutRepo;
import org.example.workouttracker.Repo.WorkoutScheduleRepo;
import org.example.workouttracker.dto.ScheduleWorkoutDTO;
import org.example.workouttracker.entity.Status;
import org.example.workouttracker.entity.Workout;
import org.example.workouttracker.entity.Workout_Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleWorkoutService {

    @Autowired
    private WorkoutRepo workoutRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private WorkoutScheduleRepo workoutScheduleRepo;

    public boolean saveScheduledWorkout(ScheduleWorkoutDTO scheduleWorkoutDTO){

        Date date = new Date();
        Workout workout = workoutRepo.findById(scheduleWorkoutDTO.getWorkoutId()).orElseThrow(() -> new RuntimeException("Workout not Found not found"));
        Status status = statusRepo.findById(scheduleWorkoutDTO.getStatusId()).orElseThrow(() -> new RuntimeException("Status not Found not found"));

        Workout_Schedule workoutSchedule = new Workout_Schedule();
        workoutSchedule.setSchedule_date(scheduleWorkoutDTO.getSchedule_date());
        workoutSchedule.setSchedule_time(scheduleWorkoutDTO.getSchedule_time());
        workoutSchedule.setWorkout(workout);
        workoutSchedule.setStatus(status);

        workoutScheduleRepo.save(workoutSchedule);

        return true;
    }

}
