package com.ys.notepad.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "login"; // default page
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/notes")
    public String notesPage() {
        return "notes";
    }

    @GetMapping("/add-note")
    public String addNotePage() {
        return "add-note";
    }
}
