package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.notifications.Notification;
import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.repositories.NotificationRepo;
import ru.egot.diplom.workout.services.NotificationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

		private final NotificationRepo notificationRepo;

		@Override
		public List<NotificationEntity> setNotificationForUser(List<Notification> notifications) throws UsernameNotFoundException {
				List<NotificationEntity> entities = notifications.stream()
						.map(n -> new NotificationEntity(
										new User(n.getUserId(), ""),
										n.getType(),
										true
								)
						)
						.toList();
				return notificationRepo.saveAll(entities);
		}

		@Override
		public void disableNotification(Notification notification) throws UsernameNotFoundException {

		}
}
