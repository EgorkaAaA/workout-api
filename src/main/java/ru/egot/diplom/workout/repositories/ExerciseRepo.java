package ru.egot.diplom.workout.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.entity.User;

import java.util.List;

public interface ExerciseRepo extends BaseRepo<ExerciseEntity> {

		List<ExerciseEntity> findAllByUserAndDeletedDateIsNull(User user);

		@Query("select t from ExerciseEntity t join TrainingEntity u on u.id = :trainingId and t.user.name = :username and t.deletedDate is null")
		List<ExerciseEntity> findAllByUserAndTrainingEntities(@Param("username") String username, @Param("trainingId") Long trainingId);
}
