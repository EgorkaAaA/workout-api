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
import java.time.LocalTime;
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
								new ExerciseEntity().setName("Стагновая тяга")
										.setUser(user)
										.setSets(10)
										.setRepeats(20)
										.setDuration("10:00")
										.setWeight(1000)
										.setComment("Осторожно на подъеме"),
								new ExerciseEntity().setName("Лодочка")
										.setUser(user)
										.setSets(2)
										.setRepeats(50)
										.setWeight(20)
										.setComment("Осторожно на подъеме"),
								new ExerciseEntity().setName("Самолетик")
										.setUser(user)
										.setSets(32)
										.setRepeats(1)
										.setDuration("60:00")
										.setWeight(2)
										.setComment("Осторожно на подъеме")
						)
				);
				Random random = new Random();
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка для спины")
								.exercises(exerciseEntities)
								.comment("Когда делал в прошлый раз потянул спину будь осторожен")
								.enabled(true)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка для ног")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.comment("Приседать аккуратно")
								.enabled(true)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка для рук")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.comment("Хрустит рука на гантелях")
								.enabled(true)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка для икр")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
//								.comment("Когда делал в прошлый раз потянул спину будь осторожен")
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка для пресса")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.comment("Попробовать брать больше веса")
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Комплексная 1 день")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Комплексаная 2 день")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.comment("Бегать нужно меньше")
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Тренировка на 1 раз")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.comment("По видосу с ютуба https://www.youtube.com/watch?v=g2pfHZhHe1Q")
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Разминка")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.enabled(false)
								.build()
				);
				trainingRepo.save(
						new TrainingEntity().toBuilder()
								.user(user)
								.name("Растяжка")
								.exercises(getExerciseEntities(random.nextInt(1, 20), user))
								.enabled(false)
								.build()
				);

				setDashboard(user);

				notificationService.setNotificationForUser(
						List.of(
								new Notification(Type.SLEEP, user.getName(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()).toString(), true),
								new Notification(Type.CALORIES, user.getName(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()).toString(), true),
								new Notification(Type.TRAINING, user.getName(), LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute()).toString(), true)
						)
				);
		}

		private List<ExerciseEntity> getExerciseEntities(int i, User user) {
				List<ExerciseEntity> exerciseEntities = new ArrayList<>();
				Random random = new Random();
				for (int j = 0; j < i; j++) {
						exerciseEntities.add(
								new ExerciseEntity().setName("12311")
										.setComment("12321321")
										.setUser(user)
										.setSets(random.nextInt(0, 200))
										.setWeight(random.nextInt(0, 200))
										.setRepeats(random.nextInt(0, 200))
										.setDuration("00:11")
						);
				}
				return exerciseEntities;
		}

		private void setDashboard(User user) {
				createSleepData().stream()
						.map(data -> DashboardDataDto.builder()
								.username(user.getName())
								.type(Type.SLEEP)
								.date(data.getDate())
								.actual(data.getActual())
								.plan(data.getPlan())
								.build()
						)
						.forEach(dashboardService::setDashboardStatistic);
				createCaloriesData().stream()
						.map(data -> DashboardDataDto.builder()
								.username(user.getName())
								.type(Type.CALORIES)
								.date(data.getDate())
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
