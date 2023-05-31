package ru.egot.diplom.workout.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.egot.diplom.workout.dto.user.UserDto;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.exceptions.UserAllReadyExistException;

public interface UserService extends UserDetailsService {

		User getUserByName(String username) throws UsernameNotFoundException;

		User createUser(UserDto user) throws UserAllReadyExistException;

}
