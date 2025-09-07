package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hangouthub.hangouthub.models.User;
import com.hangouthub.hangouthub.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("username")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    // Sign-up page
    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(User user) {
        userRepo.save(user);
        return "redirect:/login";
    }
    // Login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pswd, HttpSession session, Model model){
        User user= userRepo.findByEmail(email);

        if (user == null) {
            model.addAttribute("error","User not found!");
            return "login";
        }
        if (!user.getPswd().equals(pswd)) {
            model.addAttribute("error","Incorrect password!");
            return "login";
        }

        session.setAttribute("username",user.getName());
        return "redirect:/home-login";
    }

    // Forget-password page
    @GetMapping("/pswdreset")
    public String showForgetPswdPage() {
        return "forgetpswd";
    }

    // Home page after login
    @GetMapping("/home-login")
    public String showHomePageAfterLogin(Model model,HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "login";
        }
        // model.addAttribute("moods", moodService.getAllMoods());
        model.addAttribute("username", username);
        return "login-home";
    }
    // Log-out
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }
}
