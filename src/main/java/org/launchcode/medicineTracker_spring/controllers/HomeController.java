package org.launchcode.medicineTracker_spring.controllers;

import org.launchcode.medicineTracker_spring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private User userData;

    // Displays the registration form
    @GetMapping(value = "register/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }
    // Handles user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            User.registerUser(user);
            model.addAttribute("message", "Registration successful!");
            return "login"; // Redirect to login page after registration
        } catch (Exception e) {
            model.addAttribute("error", "An error occured during registration: " + e.getMessage());
            return "register";
        }
    }
}
