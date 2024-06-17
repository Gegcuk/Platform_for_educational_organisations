package com.gegcuk.university_management.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Achievements {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int achievements_id;

    private int user_id;
    private String title;
    private String description;
    private LocalDate date;
    public int getAchievements_id() {
        return achievements_id;
    }
    public void setAchievements_id(int achievments_id) {
        this.achievements_id = achievments_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    

}
