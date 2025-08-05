package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hangouthub.hangouthub.models.User;
import com.hangouthub.hangouthub.repository.UserRepository;

@Controller
@SessionAttributes("username")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    
    @PostMapping("/signup")
    public String signup(User user) {
        userRepo.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String pswd, Model model){
        User user= userRepo.findByEmail(email);

        if (user == null) {
            model.addAttribute("error","User not found!");
            return "login";
        }
        if (!user.getPswd().equals(pswd)) {
            model.addAttribute("error","Incorrect password!");
            return "login";
        }

        model.addAttribute("username",user.getName());
        return "redirect:/home-login";
    }
}
