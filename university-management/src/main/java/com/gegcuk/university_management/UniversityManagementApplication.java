package com.gegcuk.university_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gegcuk.university_management.model.User;
import com.gegcuk.university_management.repository.UserRepository;

@SpringBootApplication
public class UniversityManagementApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a new user
        User user = new User();
        user.setFullName("John Doe 2");
        user.setEmail("john.do21@example.com");
        user.setPassword("password".getBytes());  // In a real application, ensure passwords are hashed
        user.setRole("student");

        // Save the user to the database
        userRepository.save(user);

        // Fetch the user from the database
        userRepository.findAll().forEach(System.out::println);
    }
}
