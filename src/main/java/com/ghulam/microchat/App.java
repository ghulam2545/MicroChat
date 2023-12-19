package com.ghulam.microchat;

import com.ghulam.microchat.model.Role;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.UserRepository;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class App implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public IdGenerator idGenerator() {
		return new IdGenerator(1L, 1L);
	}

	@Override
	public void run(String... args) {
		if (userRepository.count() == 0) {

			User admin = User
					.builder()
					.id(idGenerator().nextId() + "")
					.fullname("admin")
					.email("admin@admin.com")
					.password(passwordEncoder().encode("password"))
					.role(Role.ROLE_ADMIN)
					.build();

			userRepository.save(admin);
		}
	}
}
