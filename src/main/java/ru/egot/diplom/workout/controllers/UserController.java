package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.user.UserDto;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.services.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

		private final UserService userService;

		@SneakyThrows
		@PostMapping("/registration")
		public ResponseEntity<User> registrateUser(@RequestBody UserDto user) {
				log.info("User with name: {}", user.getUsername());
				return ResponseEntity.ok(userService.createUser(user));
		}
}
