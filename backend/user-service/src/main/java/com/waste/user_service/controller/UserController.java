package com.waste.user_service.controller;

import com.waste.user_service.model.LoginRequest;
import com.waste.user_service.model.User;
import com.waste.user_service.service.UserService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/test-db")
    public String testDb() {
        try {
            // Correct way to create a Document
            Document doc = new Document("key", "value");
            mongoTemplate.getCollection("test").insertOne(doc);
            return "Inserted into MongoDB!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/points")
    public ResponseEntity<Integer> getPoints(@PathVariable String userId) {
        int points = userService.getUserPoints(userId);
        return ResponseEntity.ok(points);
    }

}
