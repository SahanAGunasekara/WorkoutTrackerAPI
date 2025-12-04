package org.example.workouttracker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleWorkoutDTO {
    private int id;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date schedule_date;

    @JsonFormat(pattern = "HH.mm.ss")
    private Time schedule_time;

    private int workoutId;

    private int statusId;
}
