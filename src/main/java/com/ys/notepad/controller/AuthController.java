package com.ys.notepad.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ys.notepad.model.User;
import com.ys.notepad.service.UserService;
    

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.signup(email, password);
            return ResponseEntity.ok("Signup successful! User ID: " + user.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        boolean result = userService.login(email, password);
        if (result) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/user-id")
public ResponseEntity<?> getUserId(@RequestParam String email) {
    User user = userService.findByEmail(email);
    if (user == null) return ResponseEntity.badRequest().body("0");
    return ResponseEntity.ok(user.getId());
}

}
