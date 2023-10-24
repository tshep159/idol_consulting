/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.app.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.app.app.dto.User;
import net.app.app.service.UserService;

/**
 *
 * @author tshepom
 */


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            UserService.writeToFile(user);
            return ResponseEntity.ok("User created successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error creating user");
        }
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            UserService.updateFile(user);
            return ResponseEntity.ok("User updated successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error updating user");
        }
    }

    @GetMapping
    public ResponseEntity<User> getUser() {
        try {
            User user = UserService.readFile();
            return ResponseEntity.ok(user);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser() {
        try {
            UserService.deleteFile();
            return ResponseEntity.ok("User file deleted successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error deleting user file");
        }
    }
}

