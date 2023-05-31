package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.*;
import ru.egot.diplom.workout.entity.Type;
import ru.egot.diplom.workout.repositories.CaloriesStatisticRepo;
import ru.egot.diplom.workout.repositories.SleepStatisticRepo;
import ru.egot.diplom.workout.services.DashboardService;
import ru.egot.diplom.workout.services.UserService;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

		private final SleepStatisticRepo sleepStatisticRepo;

		private final CaloriesStatisticRepo caloriesStatisticRepo;

		private final UserService userService;

		private final Principal securityContextHolder = SecurityContextHolder.getContext().getAuthentication();

		private final Map<Type, BiFunction<LocalDate, LocalDate, List<Statistic>>> map = Map.of(
				Type.SLEEP, this::getSleepStatistic,
				Type.CALORIES, this::getCaloriesStatistic
		);

		@Override
		public List<Dashboard> getDashboardStatistic() {
				final List<Dashboard> dashboards = new ArrayList<>();
				for (Type type : Type.values()) {
						dashboards.add(
								new Dashboard(
										type.getName(),
										map.get(type)
												.apply(LocalDate.now().minusDays(7), LocalDate.now())
												.stream()
												.map(
														s -> new DashboardData().toBuilder()
																.date(s.getDate().toString())
																.actual(s.getActual())
																.plan(s.getPlan())
																.build()
												)
												.collect(Collectors.toList())
								)
						);

				}
				return dashboards;
		}


		private List<Statistic> getSleepStatistic(LocalDate localDateTime, LocalDate localDateTime1) {
				String userName = securityContextHolder.getName();
				return sleepStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, userService.getUserByName(userName)).stream()
						.map(SleepStatisticImpl::new)
						.collect(Collectors.toList());
		}

		private List<Statistic> getCaloriesStatistic(LocalDate localDateTime, LocalDate localDateTime1) {
				String userName = securityContextHolder.getName();
				return caloriesStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, userService.getUserByName(userName)).stream()
						.map(CaloriesStatisticImpl::new)
						.collect(Collectors.toList());
		}

}
