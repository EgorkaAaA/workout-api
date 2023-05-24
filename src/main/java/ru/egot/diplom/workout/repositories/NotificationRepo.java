package ru.egot.diplom.workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.enums.GraphType;

import java.util.List;

public interface NotificationRepo extends JpaRepository<NotificationEntity, Long> {

		List<NotificationEntity> findAllByUserAndEnabledTrueAndDeletedDateIsNull(User user);

		void updateByUserAndTypeAndDeletedDateIsNull(User user, GraphType type);

		List<NotificationEntity> findAllByEnabledTrueAndDeletedDateIsNull();

}
