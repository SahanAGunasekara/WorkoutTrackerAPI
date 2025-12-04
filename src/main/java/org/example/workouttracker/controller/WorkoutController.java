package org.example.workouttracker.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpSession;
import org.example.workouttracker.dto.WorkoutDTO;
import org.example.workouttracker.entity.Workout;
import org.example.workouttracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Workout")
@CrossOrigin
public class WorkoutController {



    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/createWorkout")
    public String createWorkout(@RequestBody WorkoutDTO workoutDTO, HttpSession session){

        Boolean b = workoutService.createWorKout(workoutDTO, session);

        if(b){

            return "Succesfully Workout created";
        }

        return "Error";
    }

    @PostMapping("/updateWorkout")
    public String updateWorkout(@RequestBody WorkoutDTO workoutDTO,HttpSession session){
        boolean c = workoutService.updateWorkout(workoutDTO, session);

        if (c){
            return "Succesfully workout Updated";
        }
        return "Error";
    }

    @DeleteMapping("/deleteWorkout/{title}")
    public String deleteWorkout(@PathVariable String title,HttpSession session){
        boolean b = workoutService.deleteWorkout(title, session);

        if(b){
            return "Succesfully workout deleted";
        }

        return "Error Deleting";
    }

    @GetMapping("/userWorkoutList")
    public String pendingWorkoutList(HttpSession session){

        List<Workout> workouts = workoutService.filterWorkouts(session);

        Gson gson = new Gson();
        JsonObject responseObject = new JsonObject();
        responseObject.add("workoutList",gson.toJsonTree(workouts));
        String json = gson.toJson(responseObject);

        return json;
    }

}
