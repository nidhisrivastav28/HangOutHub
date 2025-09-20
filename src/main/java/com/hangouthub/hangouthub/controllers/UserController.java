package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.hangouthub.hangouthub.models.User;
import com.hangouthub.hangouthub.repository.UserRepository;
import com.hangouthub.hangouthub.services.EmailService;
import com.hangouthub.hangouthub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("username")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

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
    public String login(@RequestParam String email, @RequestParam String pswd, HttpSession session, Model model) {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "User not found!");
            return "login";
        }
        if (!user.getPswd().equals(pswd)) {
            model.addAttribute("error", "Incorrect password!");
            return "login";
        }

        model.addAttribute("username", user.getName());
        return "redirect:/home-login";
    }

    // Forget-password page
    @GetMapping("/pswdreset")
    public String showForgetPswdPage() {
        return "forgetpswd";
    }

    @PostMapping("/pswdreset")
    public String handleForgetPassword(@RequestParam String email, Model model) {
        try {
            String token = userService.generateResetToken(email);
            String resetLink = "http://localhost:8080/reset-password?token=" + token;

            // pass the link to email service
            emailService.sendForgotPasswordMail(email, resetLink);

            model.addAttribute("msg", "Password reset link sent to your email!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "forgetpswd";
    }

    // Show reset password page
    @GetMapping("/reset-password")
    public String showResetPassword(@RequestParam String token, Model model) {
        User user = userService.getUserByResetToken(token);
        if (user == null) {
            model.addAttribute("error", "Invalid or expired token!");
            return "forgetpswd";
        }
        model.addAttribute("token", token);
        return "reset-password";
    }

    // Handle reset password form submit
    @PostMapping("/reset-password")
    public String handleResetPassword(@RequestParam String token, @RequestParam String newPassword, Model model) {
        User user = userService.getUserByResetToken(token);
        if (user == null) {
            model.addAttribute("error", "Invalid or expired token!");
            return "forgetpswd";
        }
        userService.updatePassword(user, newPassword);
        model.addAttribute("msg", "Password updated successfully! You can login now.");
        return "login";
    }

    // Home page after login
    @GetMapping("/home-login")
    public String showHomePageAfterLogin(@ModelAttribute("username") String username, Model model) {
        if (username == null) {
            return "login";
        }

        // model.addAttribute("moods", moodService.getAllMoods());
        model.addAttribute("username", username);
        return "login-home";
    }

    // Log-out
    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus status) {
        session.invalidate();
        status.setComplete();
        return "redirect:/home";
    }
}
