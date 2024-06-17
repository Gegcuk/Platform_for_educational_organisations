package com.gegcuk.university_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gegcuk.university_management.model.Users;
import com.gegcuk.university_management.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    public Users updateUser (Users user){
        return userRepository.save(user);
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }

}
