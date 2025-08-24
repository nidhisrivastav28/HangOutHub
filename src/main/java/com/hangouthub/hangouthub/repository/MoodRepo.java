package com.hangouthub.hangouthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hangouthub.hangouthub.models.Mood;

public interface MoodRepo extends JpaRepository<Mood, Long>{
 
}
