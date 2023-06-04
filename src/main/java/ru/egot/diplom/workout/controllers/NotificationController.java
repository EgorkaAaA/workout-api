package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.notifications.Notification;
import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.services.NotificationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/notifications")
public class NotificationController {

		private final NotificationService notificationService;

		@PostMapping
		public ResponseEntity<List<NotificationEntity>> setNotifications(@RequestBody List<Notification> notification) {
				return ResponseEntity.ok(notificationService.setNotificationForUser(notification));
		}

}


