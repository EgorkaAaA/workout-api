package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.notifications.Notification;
import ru.egot.diplom.workout.entity.NotificationEntity;
import ru.egot.diplom.workout.repositories.NotificationRepo;
import ru.egot.diplom.workout.services.NotificationService;
import ru.egot.diplom.workout.services.UserService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepo notificationRepo;

    private final UserService userService;

    @Override
    public List<NotificationEntity> setNotificationForUser(List<Notification> notifications) throws UsernameNotFoundException {
        List<NotificationEntity> entities = notifications.stream()
                .map(
                        n -> new NotificationEntity(
                                userService.getUserByName(n.getUserId()),
                                n.getType(),
                                LocalTime.parse(n.getTime(), DateTimeFormatter.ofPattern("HH:mm")),
                                n.getEnabled()
                        )
                )
                .toList();
        return notificationRepo.saveAll(entities);
    }

    @Override
    public List<NotificationEntity> getNotificationForUser(String username) throws UsernameNotFoundException {
        return notificationRepo.findAllByUserAndEnabledTrueAndDeletedDateIsNullAndTimeBetween(
                userService.getUserByName(username),
                LocalTime.now().minusMinutes(5),
                LocalTime.now().plusMinutes(55)
        );
    }

    @Override
    public void disableNotification(Notification notification) throws UsernameNotFoundException {

    }
}
