package com.waste.user_service.service;

import com.waste.user_service.model.User;
import com.waste.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        // Save user (password should be encrypted in production)
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = userOptional.get();
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }
        return user;
    }

    public int getUserPoints(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return userOptional.get().getPoints();
    }
}
