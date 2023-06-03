package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class ExerciseDto {

    private final String userId;

    private final Long exerciseId;

    private final String name;

    private final Integer sets;

    private final Integer repeats;

    private final LocalTime time;

    private final Integer wight;

    private final String comment;

    private Long trainingId;
}
