package com.gegcuk.university_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gegcuk.university_management.model.Achievement;
import com.gegcuk.university_management.model.User;
import com.gegcuk.university_management.repository.AchievementRepository;
import com.gegcuk.university_management.repository.UserRepository;

@SpringBootApplication
public class UniversityManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AchievementRepository achievementRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFullName("John Doe 7");
		user.setEmail("john.doe7@example.com");
		user.setPassword("password".getBytes()); // In a real application, ensure passwords are hashed
		user.setRole("student");

		Achievement achievement = new Achievement();
		achievement.setDescription("First try");
		achievement.setTitle("First achievment");

		// Save the user to the database
		userRepository.save(user);
		achievementRepository.save(achievement);
		

		// Fetch the user from the database
		userRepository.findAll().forEach(System.out::println);
	}
}
