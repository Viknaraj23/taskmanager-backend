/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taskmanager_backend;

import com.example.taskmanager_backend.model.Task;
import com.example.taskmanager_backend.model.User;
import com.example.taskmanager_backend.repository.TaskRepository;
import com.example.taskmanager_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    // === POST /tasks/{userId} ===
    @PostMapping("/{userId}")
    public ResponseEntity<?> createTask(
            @PathVariable Long userId,
            @RequestBody Task task) {
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (userOptional.isEmpty()){
            return ResponseEntity.badRequest().body("User not found");
        }
        
        task.setUser(userOptional.get());
        taskRepository.save(task);
        
        return ResponseEntity.ok(task);
    }
    
    // === GET /tasks/{userId} ===
    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTaskByUser(@PathVariable Long userId) {
        
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        List<Task> tasks = taskRepository.findByUser(userOptional.get());
        return ResponseEntity.ok(tasks);
    }
    
    // === PUT /tasks/{taskId} ===
    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(
            @PathVariable Long taskId,
            @RequestBody Task updatedTask){
        
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        
        if (taskOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Task task = taskOptional.get();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }
    
    // === DELETE /tasks/{taskId} ===
    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        
        if (!taskRepository.existsById(taskId)){
            return ResponseEntity.notFound().build();
        }
        
        taskRepository.deleteById(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
