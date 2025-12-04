package org.example.workouttracker.controller;

import org.example.workouttracker.dto.ScheduleWorkoutDTO;
import org.example.workouttracker.service.ScheduleWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/scheduleWorkout")
@CrossOrigin
public class ScheduleWorkoutController {

    @Autowired
    private ScheduleWorkoutService scheduleWorkoutService;

    @PostMapping("/createScheduleWorkout")
    public String createScheduleWorkout(@RequestBody ScheduleWorkoutDTO scheduleWorkoutDTO){

        boolean b = scheduleWorkoutService.saveScheduledWorkout(scheduleWorkoutDTO);

        if(b){
            return "Succesfully Schedule added";
        }

        return "Error";
    }

}
