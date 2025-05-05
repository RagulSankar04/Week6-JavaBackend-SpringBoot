package com.example.SimpleJavaWebServer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("message", "Login successful!");
        } else {
            model.addAttribute("message", "Invalid credentials.");
        }
        return "result";
    }
}
