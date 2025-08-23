package com.hangouthub.hangouthub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hangouthub.hangouthub.repository.UserRepository;
import com.hangouthub.hangouthub.models.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User validateUser(String email, String pswd){
        User user = userRepo.findByEmail(email);
        if(user != null && user.getPswd().equals(pswd)){
            return user;
        }
        return null;
    }
}
