package ru.egot.diplom.workout.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.egot.diplom.workout.dto.plan.TrainingPlanDto;
import ru.egot.diplom.workout.entity.TrainingPlanEntity;

import java.util.List;

public interface TrainingPlanService {

    List<TrainingPlanEntity> setTrainingPlanForUser(TrainingPlanDto trainingPlans) throws UsernameNotFoundException;

}
