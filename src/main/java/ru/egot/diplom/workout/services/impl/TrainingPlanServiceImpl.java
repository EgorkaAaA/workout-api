package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.plan.TrainingPlanDto;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.repositories.TrainingPlanRepo;
import ru.egot.diplom.workout.services.TrainingPlanService;
import ru.egot.diplom.workout.services.TrainingService;
import ru.egot.diplom.workout.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {

		private final TrainingPlanRepo trainingPlanRepo;

		private final TrainingService trainingService;

		private final UserService userService;

		@SneakyThrows
		@Override
		public List<TrainingPlanEntity> setTrainingPlanForUser(TrainingPlanDto trainingPlan) throws UsernameNotFoundException {
				final User user = userService.getUserByName(trainingPlan.getUserId());
				return trainingPlanRepo.saveAll(
						trainingPlan.getDays()
								.stream()
								.map(
										day ->
												new TrainingPlanEntity(
														user,
														trainingService.getById(trainingPlan.getTrainingId()),
														day
												)
								)
								.toList()
				);

		}

}
