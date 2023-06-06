package ru.egot.diplom.workout.dto.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.egot.diplom.workout.entity.Type;

@Getter
@AllArgsConstructor
public class Notification {

    private Type type;

    private String userId;

    private String time;

    private Boolean enabled;

}
