package com.udr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.udr.MyService.MyServiceClass;
import com.udr.Entity.User;

@Controller
public class MyController {

    @Autowired
    private MyServiceClass myServiceClass;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        myServiceClass.saveUser(user);
        model.addAttribute("success", true);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // You can fetch and add user/project data here
        return "dashboard";
    }
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        List<User> matchedUsers = myServiceClass.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (!matchedUsers.isEmpty()) {
            model.addAttribute("user", matchedUsers.get(0)); // take the first matched user
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }


}