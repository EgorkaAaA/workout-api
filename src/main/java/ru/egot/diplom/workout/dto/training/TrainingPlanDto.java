package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@AllArgsConstructor
public class TrainingPlanDto {

    private String userId;

    private Long trainingId;

    private List<DayOfWeek> days;

}
