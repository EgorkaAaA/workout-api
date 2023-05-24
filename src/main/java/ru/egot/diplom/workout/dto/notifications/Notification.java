package ru.egot.diplom.workout.dto.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.egot.diplom.workout.enums.GraphType;

@Getter
@AllArgsConstructor
public class Notification {

		private final GraphType type;

		private final String userId;

}
