package ru.egot.diplom.workout.configs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
class Config {

		@Bean
		ObjectMapper objectMapper() {
				return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		}

		@Bean
		RestTemplate restTemplate() {
				return new RestTemplate();
		}

		@Bean
		public PasswordEncoder encoder() {
				return new BCryptPasswordEncoder();
		}

}
