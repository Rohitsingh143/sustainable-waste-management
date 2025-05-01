package com.waste.user_service.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MongoTemplate mongoTemplate;

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
}
