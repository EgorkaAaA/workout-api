package ru.egot.diplom.workout.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
public class UserDto {

		private String username;

		private String password;
}
