package com.hangouthub.hangouthub.controllers;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
// import org.springframework.ui.Model;

// import com.hangouthub.hangouthub.repository.FeedbackRepo;
import com.hangouthub.hangouthub.services.FeedbackService;

// import com.hangouthub.hangouthub.models.Mood;
// import com.hangouthub.hangouthub.services.MoodService;

// import jakarta.servlet.http.HttpSession;
 
@Controller 
@SessionAttributes("username")
public class PageController {
    @Autowired
    private FeedbackService feedbackService;
    // private MoodService moodService;

    // @ModelAttribute("username")
    // public String getUsernameFromSession(@ModelAttribute("username") String username){
    //     return username;
    // }

    //Default Home page 
    @GetMapping("/home")
    public String showHomePage(Model model, @ModelAttribute("feedbackSuccess") String success) {
        model.addAttribute("feedbackList", feedbackService.getAllFeedback());
        model.addAttribute("feedbackSuccess",success);
        return "index";
    }
    
    
    //Feedback page
    @GetMapping("/feedback")
    public String showFeedbackPage(){
        return "feedback";
    }
    //Plan page
    // @GetMapping("/plan")
    // public String showPlanPage(Model model){
    //     List<Mood> moods = moodService.getAllMoods();
    //     model.addAttribute("moods", moods);
    //     return "plan";
    // }
    
    
    
}
