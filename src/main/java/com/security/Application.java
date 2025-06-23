package com.security;

import com.security.models.User;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("admin");
		user.setPassword(bCryptPasswordEncoder.encode("password"));
		user.setEmail("admin@admin.com");
		user.setRole("ROLE_ADMIN");
		userRepository.save(user);

		User user2 = new User();
		user2.setUsername("user");
		user2.setPassword(bCryptPasswordEncoder.encode("password"));
		user2.setEmail("user2@user.com");
		user2.setRole("ROLE_USER");
		userRepository.save(user2);
	}
}
