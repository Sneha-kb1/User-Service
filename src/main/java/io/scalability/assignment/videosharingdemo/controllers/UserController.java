package io.scalability.assignment.videosharingdemo.controllers;


import io.scalability.assignment.videosharingdemo.services.UserService;
import io.scalability.assignment.videosharingdemo.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    //  register a user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        userService.register(username, password);
        return ResponseEntity.ok("User saved successfully.");

    }

    // login a user
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        userService.login(username, password);
        return ResponseEntity.ok("User login successfull.");
    }

    // change password
    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) throws IOException {
        userService.changePassword(username, oldPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully.");
    }

}
