package com.gegcuk.university_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gegcuk.university_management.model.Achievements;

public interface AchievementRepository extends JpaRepository<Achievements, Integer> {
    
}
