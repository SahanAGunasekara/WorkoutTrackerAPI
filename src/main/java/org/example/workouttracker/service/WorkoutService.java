package org.example.workouttracker.service;

import jakarta.servlet.http.HttpSession;
import org.example.workouttracker.Repo.ExerciseRepo;
import org.example.workouttracker.Repo.StatusRepo;
import org.example.workouttracker.Repo.WorkoutExerciseRepo;
import org.example.workouttracker.Repo.WorkoutRepo;
import org.example.workouttracker.dto.WorkoutDTO;
import org.example.workouttracker.dto.WorkoutExerciseDTO;
import org.example.workouttracker.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepo workoutRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private ExerciseRepo exerciseRepo;
    @Autowired
    private WorkoutExerciseRepo workoutExerciseRepo;

    public boolean createWorKout(WorkoutDTO workoutDTO, HttpSession session){

        User user = (User) session.getAttribute("User");

        Status status = statusRepo.findById(workoutDTO.getStatus()).orElseThrow(() -> new RuntimeException("Status nor Found not found"));

        Date date = new Date();

        Workout workout = new Workout();
        workout.setUser(user);
        workout.setTitle(workoutDTO.getTitle());
        workout.setNote(workoutDTO.getNote());
        workout.setStatus(status);
        workout.setCreated_at(date);
        workout.setUpdatedAt(date);

        Workout savedWorkout = workoutRepo.save(workout);



        for (WorkoutExerciseDTO workoutExerciseDTO:workoutDTO.getWorkoutExerciseDTOList()){
            Exercise exercise = exerciseRepo.findById(workoutExerciseDTO.getExerciseId()).orElseThrow(() -> new RuntimeException("Exercise nor Found not found"));
            Workout_Exercise workoutExercise= new Workout_Exercise();
            workoutExercise.setDuration(workoutExerciseDTO.getDuration());
            workoutExercise.setOrderNo(workoutExerciseDTO.getOrderNumber());
            workoutExercise.setReps(workoutExerciseDTO.getReps());
            workoutExercise.setSets(workoutExerciseDTO.getSets());
            workoutExercise.setWeight(workoutExerciseDTO.getWeight());
            workoutExercise.setExercise(exercise);
            workoutExercise.setWorkout(savedWorkout);

            workoutExerciseRepo.save(workoutExercise);
        }

        return true;
    }

    public boolean updateWorkout(WorkoutDTO workoutDTO,HttpSession session){
        Date date = new Date();
        Status status = statusRepo.findById(1).orElseThrow(() -> new RuntimeException("Status nor Found not found"));
        List<Workout> workoutList = workoutRepo.findByTitleAndStatus(workoutDTO.getTitle(), status);
        Workout workout = workoutList.get(0);
        workout.setTitle(workoutDTO.getTitle());
        workout.setNote(workoutDTO.getNote());
        workout.setUpdatedAt(date);
        workout.setStatus(statusRepo.findById(workoutDTO.getStatus()).orElseThrow(() -> new RuntimeException("Status not Found not found")));
        workout.setUser((User)session.getAttribute("User"));

        Workout savedWorkout = workoutRepo.save(workout);

        if(!workoutDTO.getWorkoutExerciseDTOList().isEmpty()){
            List<Workout_Exercise> workoutExercise = workoutExerciseRepo.findByWorkout(workout);
            List<WorkoutExerciseDTO> workoutExerciseDTOS=workoutDTO.getWorkoutExerciseDTOList();

            for(int i =0; i<workoutExercise.size();i++){
                Workout_Exercise ex = workoutExercise.get(i);
                if(i<workoutExerciseDTOS.size()){
                    Exercise exercise = exerciseRepo.findById(workoutExerciseDTOS.get(i).getExerciseId()).orElseThrow(() -> new RuntimeException("Exercise nor Found not found"));
                    ex.setDuration(workoutExerciseDTOS.get(i).getDuration());
                    ex.setOrderNo(workoutExerciseDTOS.get(i).getOrderNumber());
                    ex.setReps(workoutExerciseDTOS.get(i).getReps());
                    ex.setSets(workoutExerciseDTOS.get(i).getSets());
                    ex.setWeight(workoutExerciseDTOS.get(i).getWeight());
                    ex.setExercise(exercise);
                    ex.setWorkout(savedWorkout);

                    workoutExerciseRepo.save(ex);
                }
            }

        }

        return true;
    }

    public boolean deleteWorkout(String title,HttpSession session){
        List<Workout> workout = workoutRepo.findByTitleAndUser(title, (User) session.getAttribute("User"));
        List<Workout_Exercise> workExercise = workoutExerciseRepo.findByWorkout(workout.get(0));
        for(Workout_Exercise Wexercise:workExercise){
            workoutExerciseRepo.delete(Wexercise);
        }
        //workoutExerciseRepo.deleteAll(workExercise);
        workoutRepo.delete(workout.get(0));
        return true;
    }

    public List<Workout> filterWorkouts(HttpSession session){

        Status status = statusRepo.findById(1).orElseThrow(() -> new RuntimeException("Status not Found not found"));
        User user = (User) session.getAttribute("User");

        List<Workout> workoutList = workoutRepo.findByStatusAndUser(status, user,Sort.by("updated_at").descending());

        return workoutList;
    }

}
