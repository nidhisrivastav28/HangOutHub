package com.hangouthub.hangouthub.services_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangouthub.hangouthub.models.Feedback;
import com.hangouthub.hangouthub.repository.FeedbackRepo;
import com.hangouthub.hangouthub.services.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }
    
}
