package ru.egot.diplom.workout.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.egot.diplom.workout.dto.notifications.Notification;
import ru.egot.diplom.workout.entity.NotificationEntity;

import java.util.List;

public interface NotificationService {

		List<NotificationEntity> setNotificationForUser(List<Notification> notification) throws UsernameNotFoundException;

		void disableNotification(Notification notification) throws UsernameNotFoundException;
}
