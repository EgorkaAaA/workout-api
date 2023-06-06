package ru.egot.diplom.workout.repositories;

import jakarta.validation.constraints.NotNull;
import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.entity.User;

import java.time.LocalTime;
import java.util.List;

public interface NotificationRepo extends BaseRepo<NotificationEntity> {

    List<NotificationEntity> findAllByUserAndEnabledTrueAndDeletedDateIsNullAndTimeBetween(@NotNull User user, @NotNull LocalTime time, @NotNull LocalTime time2);

//		void updateByUserAndTypeAndDeletedDateIsNull(User user, GraphType type);

    List<NotificationEntity> findAllByEnabledTrueAndDeletedDateIsNull();

}
