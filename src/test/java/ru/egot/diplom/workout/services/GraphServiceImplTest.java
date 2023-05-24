package ru.egot.diplom.workout.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.egot.diplom.workout.dto.statistic.DashboardData;
import ru.egot.diplom.workout.entity.CaloriesEntity;
import ru.egot.diplom.workout.entity.SleepEntity;
import ru.egot.diplom.workout.repositories.CaloriesStatisticRepo;
import ru.egot.diplom.workout.repositories.SleepStatisticRepo;
import ru.egot.diplom.workout.services.impl.GraphServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@Disabled
class GraphServiceImplTest {

		@MockBean
		private CaloriesStatisticRepo caloriesStatisticRepo;

		@MockBean
		private SleepStatisticRepo sleepStatisticRepo;

		@BeforeAll
		void setUp() {
				when(caloriesStatisticRepo.findAllByDateBetweenAndUserId(any(), any(), anyLong())).thenReturn(
						getCaloriesEntity()
				);
				when(sleepStatisticRepo.findAllByDateBetweenAndUserId(any(), any(), anyLong())).thenReturn(
						getSleepEntity()
				);
		}

		@Test
		@Disabled
		void getDashboardStatistic() {
				final GraphServiceImpl graphService = new GraphServiceImpl(sleepStatisticRepo, caloriesStatisticRepo);
				List<DashboardData> dashboardDataCalories = Collections.singletonList(new DashboardData().toBuilder()
						.date("2023-01-01")
						.build());


				graphService.getDashboardStatistic();
		}

		private List<CaloriesEntity> getCaloriesEntity() {
				List<CaloriesEntity> caloriesEntities = new ArrayList<>();
				for (int i = 0; i < 7; i++) {
						caloriesEntities.add(
								new CaloriesEntity(
										1L,
										LocalDate.now().minusDays(i),
										1000,
										1000
								)
						);
				}
				return caloriesEntities;
		}

		private List<SleepEntity> getSleepEntity() {
				List<SleepEntity> caloriesEntities = new ArrayList<>();
				for (int i = 0; i < 7; i++) {
						caloriesEntities.add(
								new SleepEntity(
										1L,
										LocalDate.now().minusDays(i),
										7,
										8
								)
						);
				}
				return caloriesEntities;
		}

}