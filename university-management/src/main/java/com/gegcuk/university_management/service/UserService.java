package com.gegcuk.university_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.university_management.model.User;
import com.gegcuk.university_management.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser (User user){
        return userRepository.save(user);
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

}
