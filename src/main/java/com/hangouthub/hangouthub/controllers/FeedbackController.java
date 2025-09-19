package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hangouthub.hangouthub.models.Feedback;
import com.hangouthub.hangouthub.services.FeedbackService;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // show feedback form
    @GetMapping("/feedback")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    // save feedback
    @PostMapping("/feedback")
    public String saveFeedback(@ModelAttribute Feedback feedback, RedirectAttributes redirectAttributes) {
        feedbackService.saveFeedback(feedback);
        redirectAttributes.addFlashAttribute("feedbackSuccess", true);
        return "redirect:/feedback"; // 👈 home mapping pe bhej do
    }

    // @PostMapping("/feedback")
    // public String saveFeedback(@ModelAttribute Feedback feedback,
    // RedirectAttributes redirectAttributes){
    // feedbackService.saveFeedback((feedback));
    // redirectAttributes.addFlashAttribute("feedbackSuccess", true);
    // return "redirect:/feedback";
    // }

    // display feedback
    // @GetMapping("/home")
    // public String getAllFeedback(Model model){
    // model.addAttribute("feedbackList", feedbackService.getAllFeedback());
    // return "feedback-list";
    // }

}
