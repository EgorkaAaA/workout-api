package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.training.ExerciseDto;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.exceptions.NotFoundException;
import ru.egot.diplom.workout.repositories.ExerciseRepo;
import ru.egot.diplom.workout.repositories.TrainingRepo;
import ru.egot.diplom.workout.services.ExerciseService;
import ru.egot.diplom.workout.services.UserService;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

		private final ExerciseRepo exerciseRepo;

		private final UserService userService;

		private final TrainingRepo trainingRepo;

		@Override
		public ExerciseEntity createExercise(ExerciseDto exerciseDto) {
				return exerciseRepo.save(map(exerciseDto));
		}

		@Override
		public List<ExerciseEntity> createExerciseList(List<ExerciseDto> exerciseDtoList) {
				return exerciseRepo.saveAll(mapAll(exerciseDtoList));
		}

		@Override
		public List<ExerciseEntity> findAllByUserId(String userId) {
				return exerciseRepo.findAllByUserAndDeletedDateIsNull(userService.getUserByName(userId));
		}

		@Override
		public List<ExerciseEntity> findAllByUserIdAndTrainingId(String userId, Long trainingId) {
				return exerciseRepo.findAllByUserAndTrainingEntities(userId, trainingId);
		}

		@Override
		public ExerciseEntity findById(Long id) {
				return exerciseRepo.findById(id).orElseThrow(() -> new NotFoundException("Exercise with id: %s not found".formatted(id)));
		}

		@Override
		public ExerciseEntity updateById(Long id, ExerciseDto exerciseDto) {
				return findById(id).setName(exerciseDto.getName())
						.setTrainingEntities(
								trainingRepo.findByIdAndDeletedDateIsNull(exerciseDto.getTrainingId())
										.map(Collections::singletonList)
										.orElseThrow(() -> new NotFoundException("Training with id: %s not found".formatted(exerciseDto.getTrainingId())))
						)
						.setSets(exerciseDto.getSets())
						.setRepeats(exerciseDto.getRepeats())
						.setWeight(exerciseDto.getWight())
						.setTime(LocalTime.parse(exerciseDto.getTime()))
						.setComment(exerciseDto.getComment());
		}

		@Override
		public ExerciseEntity map(ExerciseDto exerciseDto) {
				final Long exerciseId = exerciseDto.getExerciseId();
				if (exerciseId != null) {
						return exerciseRepo.findById(exerciseId)
								.orElseThrow(() -> new NotFoundException("Exercise with id: %s not found".formatted(exerciseId)));
				}
				return new ExerciseEntity().setUser(userService.getUserByName(exerciseDto.getUserId()))
						.setTrainingEntities(
								exerciseDto.getTrainingId() == null ? null :
								trainingRepo.findByIdAndDeletedDateIsNull(exerciseDto.getTrainingId())
										.map(Collections::singletonList)
										.orElseThrow(() -> new NotFoundException("Training with id: %s not found".formatted(exerciseDto.getTrainingId())))
						)
						.setName(exerciseDto.getName())
						.setSets(exerciseDto.getSets())
						.setRepeats(exerciseDto.getRepeats())
						.setWeight(exerciseDto.getWight())
						.setTime(LocalTime.parse(exerciseDto.getTime()))
						.setComment(exerciseDto.getComment());
		}

		@Override
		public List<ExerciseEntity> mapAll(List<ExerciseDto> exerciseDtoList) {
				return exerciseDtoList.stream()
						.map(this::map)
						.toList();
		}
}
