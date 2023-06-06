package ru.egot.diplom.workout.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.notifications.Notification;
import ru.egot.diplom.workout.dto.statistic.DashboardData;
import ru.egot.diplom.workout.dto.statistic.DashboardDataDto;
import ru.egot.diplom.workout.entity.ExerciseEntity;
import ru.egot.diplom.workout.entity.TrainingEntity;
import ru.egot.diplom.workout.entity.Type;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.repositories.ExerciseRepo;
import ru.egot.diplom.workout.repositories.TrainingRepo;
import ru.egot.diplom.workout.repositories.UserRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SeaderService {

    private final UserRepo userRepo;

    private final TrainingRepo trainingRepo;

    private final ExerciseRepo exerciseRepo;

    private final PasswordEncoder passwordEncoder;

    private final NotificationService notificationService;

    private final DashboardService dashboardService;

    @PostConstruct
    public void seed() {
        User user = userRepo.save(new User("@Egorkaaaa", passwordEncoder.encode("123")));
        List<ExerciseEntity> exerciseEntities = exerciseRepo.saveAll(List.of(
                new ExerciseEntity().setName("Вадим лох")
                        .setUser(user)
                        .setSets(10)
                        .setRepeats(20)
                        .setTime("10:00")
                        .setWeight(1000)
                        .setComment("Поднять Вадима массой 1000 кг на 10 минут так по 20 раз в 10 подходов"),
                new ExerciseEntity().setName("Егор лох")
                        .setUser(user)
                        .setSets(2)
                        .setRepeats(50)
                        .setWeight(20)
                        .setComment("Поднять Егора массой 20 кг над головой и попустить так по 50 раз в 2 подхода"),
                new ExerciseEntity().setName("Дима лох")
                        .setUser(user)
                        .setSets(32)
                        .setRepeats(1)
                        .setTime("60:00")
                        .setWeight(2)
                        .setComment("Подбросить Диму массой 2 кг на 60 минут так по 1 раз в 32 подхода")
                )
        );
        trainingRepo.save(
                new TrainingEntity().toBuilder()
                        .user(user)
                        .name("Мега лоховская треня")
                        .exercises(exerciseEntities)
                        .comment("Когда делал в прошлый раз потянул спину будь осторожен")
                        .enabled(true)
                        .build()
        );

        setDashboard(user);

        notificationService.setNotificationForUser(
                List.of(
                        new Notification(Type.SLEEP, user.getName(), LocalDate.now().toString(), true),
                        new Notification(Type.CALORIES, user.getName(), LocalDate.now().toString(), true),
                        new Notification(Type.TRAINING, user.getName(), LocalDate.now().toString(), true)
                )
        );
    }

    private void setDashboard(User user) {
        createSleepData().stream()
                .map(data -> DashboardDataDto.builder()
                        .username(user.getName())
                        .type(Type.SLEEP)
                        .date(LocalDate.now().toString())
                        .actual(data.getActual())
                        .plan(data.getPlan())
                        .build()
                )
                .forEach(dashboardService::setDashboardStatistic);
        createCaloriesData().stream()
                .map(data -> DashboardDataDto.builder()
                        .username(user.getName())
                        .type(Type.SLEEP)
                        .date(LocalDate.now().toString())
                        .actual(data.getActual())
                        .plan(data.getPlan())
                        .build()
                )
                .forEach(dashboardService::setDashboardStatistic);

    }

    private List<DashboardData> createSleepData() {
        ArrayList<DashboardData> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int actual = random.nextInt(0, 12);
            list.add(
                    new DashboardData(
                            LocalDate.now().minusDays(i).toString(),
                            8,
                            actual,
                            8,
                            0
                    )
            );
        }
        double avg = list.stream().mapToDouble(DashboardData::getActual).average().orElse(0);
        return list.stream().map(r -> r.setActualAvg(avg)).toList();
    }

    private List<DashboardData> createCaloriesData() {
        ArrayList<DashboardData> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int actual = random.nextInt(1500, 5000);
            list.add(
                    new DashboardData(
                            LocalDate.now().minusDays(i).toString(),
                            3000,
                            actual,
                            3000,
                            0
                    )
            );
        }
        double avg = list.stream().mapToDouble(DashboardData::getActual).average().orElse(0);
        return list.stream().map(r -> r.setActualAvg(avg)).toList();
    }
}
