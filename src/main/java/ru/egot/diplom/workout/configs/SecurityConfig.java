package ru.egot.diplom.workout.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.egot.diplom.workout.services.UserService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

		private final UserService userService;

		private final PasswordEncoder passwordEncoder;

		@Bean
		SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				return http.csrf().disable()
						.cors().disable()
						.userDetailsService(userService)
						.authenticationProvider(getAuthProvider())
						.authorizeHttpRequests(
								request -> request
										.requestMatchers("/registration", "/public/**").permitAll()
										.anyRequest().authenticated()
						)
						.formLogin(
								(form) -> form.permitAll()
										.disable()
						)
						.logout(LogoutConfigurer::permitAll)
						.build();
		}

		private AuthenticationProvider getAuthProvider() {
				DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
				authProvider.setPasswordEncoder(passwordEncoder);
				authProvider.setUserDetailsService(userService);
				return authProvider;
		}

}
