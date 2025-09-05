package com.hangouthub.hangouthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hangouthub.hangouthub.models.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long>{

}
