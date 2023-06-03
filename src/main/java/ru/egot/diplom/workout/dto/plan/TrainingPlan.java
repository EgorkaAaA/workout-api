package ru.egot.diplom.workout.dto.plan;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@AllArgsConstructor
public class TrainingPlan {

    private final String userId;

    private final String trainingId;

    private final List<DayOfWeek> days;

}
