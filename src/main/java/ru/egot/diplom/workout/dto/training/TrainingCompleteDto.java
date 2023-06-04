package ru.egot.diplom.workout.dto.training;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TrainingCompleteDto {

		private final String userId;

		private final Long trainingId;

		private final LocalDateTime days;

}
