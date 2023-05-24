package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.statistic.*;
import ru.egot.diplom.workout.enums.GraphType;
import ru.egot.diplom.workout.repositories.CaloriesStatisticRepo;
import ru.egot.diplom.workout.repositories.SleepStatisticRepo;
import ru.egot.diplom.workout.services.DashboardService;

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

		private final Principal securityContextHolder = SecurityContextHolder.getContext().getAuthentication();

		private final Map<GraphType, BiFunction<LocalDate, LocalDate, List<Statistic>>> map = Map.of(
				GraphType.SLEEP, this::getSleepStatistic,
				GraphType.CALORIES, this::getCaloriesStatistic
		);

		@Override
		public List<Dashboard> getDashboardStatistic() {
				final List<Dashboard> dashboards = new ArrayList<>();
				for (GraphType type : GraphType.values()) {
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
																.planAvg(1)
																.actualAvg(1)
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
				return sleepStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, Long.valueOf(userName)).stream()
						.map(SleepStatisticImpl::new)
						.collect(Collectors.toList());
		}

		private List<Statistic> getCaloriesStatistic(LocalDate localDateTime, LocalDate localDateTime1) {
				String userName = securityContextHolder.getName();
				return caloriesStatisticRepo.findAllByDateBetweenAndUserId(localDateTime, localDateTime1, Long.valueOf(userName)).stream()
						.map(CaloriesStatisticImpl::new)
						.collect(Collectors.toList());
		}

}
