package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.plan.TrainingPlan;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.repositories.TrainingPlanRepo;
import ru.egot.diplom.workout.services.TrainingPlanService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingPlanServiceImpl implements TrainingPlanService {

		private final TrainingPlanRepo trainingPlanRepo;

		@Override
		public TrainingPlanEntity setTrainingPlanForUser(TrainingPlan trainingPlans) throws UsernameNotFoundException {
				final User user = new User(trainingPlans.getUserId(), "");
				return trainingPlanRepo.save(
						new TrainingPlanEntity(
								user,
								getExerciseEntities(trainingPlans, user),
								trainingPlans.getComment(),
								true,
								trainingPlans.getDays()
						)
				);

		}

		private static List<ExerciseEntity> getExerciseEntities(TrainingPlan t, User user) {
				return t.getExercises().stream().map(e -> new ExerciseEntity(user, e.getName(), e.getSets(), e.getRepeats(), e.getComment())).toList();
		}
}
