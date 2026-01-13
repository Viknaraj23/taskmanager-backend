/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taskmanager_backend.model;

import jakarta.persistence.*;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column
    private String description;
    
    @Column(nullable = false)
    private boolean completed = false;
    
    
    // === Many-to-One Relationship with User ===
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    
    // === Constructors ===
    public Task(){}
    
    public Task(String title, String description, User user){
        this.title = title;
        this.description = description;
        this.user = user;
    }
    
    // === Getters & Setters ===
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public boolean isCompleted(){
        return completed;
    }
    
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
}
