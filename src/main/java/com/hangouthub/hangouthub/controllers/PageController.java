package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import com.hangouthub.hangouthub.services.MoodService;

@Controller
@SessionAttributes("username")
public class PageController {
    @Autowired
    private MoodService moodService;

    // @ModelAttribute("username")
    // public String getUsernameFromSession(@ModelAttribute("username") String username){
    //     return username;
    // }

    // Home page after login
    @GetMapping("/home-login")
    public String showHomePage(Model model, @ModelAttribute("username") String username) {
        model.addAttribute("moods", moodService.getAllMoods());
        model.addAttribute("username", username);
        return "login-home";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }
    @GetMapping("/forgetpswd")
    public String showForgetPswdPage() {
        return "forgetpswd";
    }
    @GetMapping("/home")
    public String showHomePage() {
        return "index";
    }
}
