package com.ghulam.microchat;

import com.ghulam.microchat.model.Links;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.UserRepository;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@SpringBootApplication
public class App implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		User user = new User();
		user.setUserId(IdGenerator.next());
		user.setRole("ROLE_USER");
		user.setFirstName("my");
		user.setLastName("user");
		user.setUsername("user@gmail.com");
		user.setPassword(passwordEncoder.encode("user"));
		user.setCountry("CHINA");
		user.setLinks(new Links(IdGenerator.next(), "instagram.com", "facebook.com", "youtube.com"));

		User admin = new User();
		admin.setUserId(IdGenerator.next());
		admin.setRole("ROLE_ADMIN");
		admin.setFirstName("my");
		admin.setLastName("admin");
		admin.setUsername("admin@gmail.com");
		admin.setPassword(passwordEncoder.encode("admin"));
		admin.setCountry("CHINA");
		admin.setLinks(new Links(IdGenerator.next(), "instagram.com", "facebook.com", "youtube.com"));


		userRepository.save(user);
		userRepository.save(admin);
	}
}
