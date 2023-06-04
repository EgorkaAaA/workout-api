package ru.egot.diplom.workout.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.training.api.TrainingApiDifficulty;
import ru.egot.diplom.workout.dto.training.api.TrainingApiMuscle;
import ru.egot.diplom.workout.dto.training.api.TrainingApiResponse;
import ru.egot.diplom.workout.dto.training.api.TrainingApiType;
import ru.egot.diplom.workout.services.SenderService;
import ru.egot.diplom.workout.services.TrainingApiSender;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TrainingApiSenderImpl implements TrainingApiSender {

		private final SenderService senderService;

		@Value("${api.training.url}")
		private String url;

		@Value("${api.training.key}")
		private String apiKey;

		@SneakyThrows
		@Override
		public List<TrainingApiResponse> getExercises(TrainingApiType type, TrainingApiMuscle muscle, TrainingApiDifficulty difficulty, Integer offset) {
				Map<String, String> uriVariables = new HashMap<>();
				if (type != null) {
						uriVariables.put("type", type.getName());
				}
				if (difficulty != null) {
						uriVariables.put("difficulty", difficulty.getName());
				}
				if (muscle != null) {
						uriVariables.put("muscle", muscle.getName());
				}
				uriVariables.put("offset", offset.toString());
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.set("X-Api-Key", apiKey);
				return Arrays.stream(
								Objects.requireNonNull(
										senderService.get(
														url,
														TrainingApiResponse[].class,
														new HttpEntity<>(httpHeaders),
														uriVariables
												)
												.getBody()))
						.toList();
		}
}
