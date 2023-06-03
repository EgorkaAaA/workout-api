package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class TrainingDto {

    private final String userId;

    private final List<ExerciseDto> exerciseDtos;

    private final String comment;

    private final Boolean enabled;

}
