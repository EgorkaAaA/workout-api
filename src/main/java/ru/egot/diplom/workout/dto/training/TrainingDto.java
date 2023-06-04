package ru.egot.diplom.workout.dto.training;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
public class TrainingDto {

    private String userId;

    private List<ExerciseDto> exerciseDtoList;

    private String comment;

    private Boolean enabled;

}
