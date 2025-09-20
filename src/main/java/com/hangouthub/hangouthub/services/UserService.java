package com.hangouthub.hangouthub.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hangouthub.hangouthub.repository.UserRepository;
import com.hangouthub.hangouthub.models.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    // Login Validation
    public User validateUser(String email, String pswd){
        User user = userRepo.findByEmail(email);
        if(user != null && user.getPswd().equals(pswd)){
            return user;
        }
        return null;
    }

    // 🔹 Forgot password token generate
    public String generateResetToken(String email) {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }

        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setTokenExpiry(LocalDateTime.now().plusMinutes(30)); // 30 min valid
        userRepo.save(user);

        return token;
    }

    // 🔹 Token se user find karna (reset ke waqt)
    public User getUserByResetToken(String token) {
        return userRepo.findByResetToken(token);
    }

    // 🔹 Password reset karna
    public void updatePassword(User user, String newPassword) {
        user.setPswd(newPassword); // hashing lagana better hai
        user.setResetToken(null);
        user.setTokenExpiry(null);
        userRepo.save(user);
    }
}
