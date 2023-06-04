package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TrainingCompleteDto {

    private String userId;

    private Long trainingId;

    private LocalDateTime days;

}
