package ru.egot.diplom.workout.services.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.egot.diplom.workout.dto.user.UserDto;
import ru.egot.diplom.workout.entity.User;
import ru.egot.diplom.workout.exceptions.UserAllReadyExistException;
import ru.egot.diplom.workout.repositories.UserRepo;
import ru.egot.diplom.workout.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

		private final UserRepo userRepo;

		private final PasswordEncoder passwordEncoder;

		@PostConstruct
		public void addUser() {
				userRepo.save(new User("@Egorkaaaa", passwordEncoder.encode("123")));
		}

		@Override
		public User getUserByName(String username) throws UsernameNotFoundException {
				User user = userRepo.findByNameAndDeletedDateIsNull(username);
				if (user == null) {
						throw new UsernameNotFoundException("User with name: %s not found!".formatted(username));
				}
				return user;
		}

		@Override
		public User createUser(UserDto user) throws UserAllReadyExistException {
				if (userRepo.findByNameAndDeletedDateIsNull(user.getUsername()) != null) {
						throw new UserAllReadyExistException("User with name: %s all ready exist".formatted(user.getUsername()));
				}
				return new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
		}

		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = getUserByName(username);
				if (user == null) {
						throw new UsernameNotFoundException("No user found with username: " + username);
				}
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;

				return new org.springframework.security.core.userdetails.User(
						user.getName(),
						user.getPassword(),
						enabled,
						accountNonExpired,
						credentialsNonExpired,
						accountNonLocked,
						getAuthorities(List.of("ROLE_USER"))
				);
		}

		private List<GrantedAuthority> getAuthorities(List<String> roles) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				for (String role : roles) {
						authorities.add(new SimpleGrantedAuthority(role));
				}
				return authorities;
		}
}
