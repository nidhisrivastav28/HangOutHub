package com.hangouthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hangouthub.models.Mood;

public interface MoodRepo extends JpaRepository<Mood, Long>{

}
