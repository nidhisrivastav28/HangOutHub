package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import com.hangouthub.hangouthub.services.BudgetService;
// import com.hangouthub.hangouthub.services.LocationService;
// import com.hangouthub.hangouthub.services.MoodService;
import com.hangouthub.hangouthub.services.PlaceService;

@Controller
@RequestMapping("/plan")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public String showForm(){
        return "plan";
    }
    @PostMapping
    public String getPlaces(
        @RequestParam("mood") Long mood, 
        @RequestParam("location")Long locations,
        @RequestParam("budget") Long budget,
        Model model){
            
            var places = placeService.getPlacesByFilters(mood,locations,budget);
            model.addAttribute("places",places);

            return "plan";
        }
}
