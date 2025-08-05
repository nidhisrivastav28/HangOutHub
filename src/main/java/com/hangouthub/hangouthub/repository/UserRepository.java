package com.hangouthub.hangouthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hangouthub.hangouthub.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

}
