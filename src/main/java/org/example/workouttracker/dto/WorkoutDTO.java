package org.example.workouttracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.workouttracker.entity.User;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDTO {

    private String note;
    private String title;
    private Date created_at;
    private Date updated_at;
    private int status;
    private User user;
    private List<WorkoutExerciseDTO> workoutExerciseDTOList;
}
