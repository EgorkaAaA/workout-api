package ru.egot.diplom.workout.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

		private final String username;

		private final String password;
}
