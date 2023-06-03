package ru.egot.diplom.workout.repositories;

import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.entity.User;

import java.util.List;

public interface NotificationRepo extends BaseRepo<NotificationEntity> {

		List<NotificationEntity> findAllByUserAndEnabledTrueAndDeletedDateIsNull(User user);

//		void updateByUserAndTypeAndDeletedDateIsNull(User user, GraphType type);

		List<NotificationEntity> findAllByEnabledTrueAndDeletedDateIsNull();

}
