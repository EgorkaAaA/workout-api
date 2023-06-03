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

    private String userId;

    private List<Exercise> exercises;

    private String comment;

    private Boolean enabled;

}
