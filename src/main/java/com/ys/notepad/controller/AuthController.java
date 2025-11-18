package com.ys.notepad.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ys.notepad.model.User;
import com.ys.notepad.service.UserService;
    

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
public String signup(@RequestParam String email, @RequestParam String password) {
    try {
        userService.signup(email, password);
        return "redirect:/login";     // 🔥 Redirect to login page
    } catch (IllegalArgumentException e) {
        return "redirect:/signup?error=" + e.getMessage();
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
