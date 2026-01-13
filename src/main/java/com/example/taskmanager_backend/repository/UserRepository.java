/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.taskmanager_backend.repository;

import com.example.taskmanager_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Optional method to fing user by username
    Optional<User> findByUsername(String username);
}
