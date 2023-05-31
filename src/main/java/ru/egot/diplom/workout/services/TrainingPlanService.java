package ru.egot.diplom.workout.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.egot.diplom.workout.dto.plan.TrainingPlan;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;

public interface TrainingPlanService {

    TrainingPlanEntity setTrainingPlanForUser(TrainingPlan trainingPlans) throws UsernameNotFoundException;

}
