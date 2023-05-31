package ru.egot.diplom.workout.dto.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.egot.diplom.workout.entity.Type;

@Getter
@AllArgsConstructor
public class Notification {

		private final Type type;

		private final String userId;

		private final Boolean enabled;

}
