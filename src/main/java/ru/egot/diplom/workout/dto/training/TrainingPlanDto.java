package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@AllArgsConstructor
public class TrainingPlanDto {

    private final String userId;

    private final Long trainingId;

    private final List<DayOfWeek> days;

}
