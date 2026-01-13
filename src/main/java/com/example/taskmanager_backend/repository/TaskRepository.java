/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.taskmanager_backend.repository;

import com.example.taskmanager_backend.model.Task;
import com.example.taskmanager_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author USER
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Get tasks for a specific uesr
    List<Task> findByUser(User user);
}
