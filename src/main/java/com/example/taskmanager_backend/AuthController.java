/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taskmanager_backend;

import com.example.taskmanager_backend.model.User;
import com.example.taskmanager_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    
    // === POST /auth/register ===
   @PostMapping("/register")
public ResponseEntity<String> register(@RequestBody User user){
    System.out.println("DEBUG: username=" + user.getUsername() + ", password=" + user.getPassword());
    
    if(user.getPassword() == null){
        return ResponseEntity.badRequest().body("Password is null!");
    }
    
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return ResponseEntity.ok("User registered successfully");
}
    
    // === POST /auth/login ===
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            User u = existingUser.get();
            
            // Check password
            if (passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(401).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
    
}
