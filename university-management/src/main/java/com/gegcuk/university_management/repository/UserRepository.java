package com.gegcuk.university_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gegcuk.university_management.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
