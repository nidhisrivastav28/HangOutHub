package com.hangouthub.hangouthub.services;

import java.util.List;

import com.hangouthub.hangouthub.models.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedback();
}
