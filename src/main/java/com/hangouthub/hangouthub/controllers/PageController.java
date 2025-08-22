package com.hangouthub.hangouthub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import com.hangouthub.hangouthub.models.Mood;
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

    //Default Home page 
    @GetMapping("/home")
    public String showHomePage() {
        return "index";
    }
    // Login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    // Sign-up page
    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }
    // Forget-password page
    @GetMapping("/forgetpswd")
    public String showForgetPswdPage() {
        return "forgetpswd";
    }
    //Feedback page
    @GetMapping("/feedback")
    public String showFeedbackPage(){
        return "feedback";
    }

    //Plan page
    @GetMapping("/plan")
    public String showPlanPage(Model model){
        List<Mood> moods = moodService.getAllMoods();
        model.addAttribute("moods", moods);
        return "plan";
    }
    // Home page after login
    @GetMapping("/home-login")
    public String showHomePage(Model model, @ModelAttribute("username") String username) {
        model.addAttribute("moods", moodService.getAllMoods());
        model.addAttribute("username", username);
        return "login-home";
    }
    
    
}
