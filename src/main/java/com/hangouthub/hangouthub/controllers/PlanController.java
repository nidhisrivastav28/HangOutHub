package com.hangouthub.hangouthub.controllers;

import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.models.Places;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestAttribute;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

// import com.hangouthub.hangouthub.models.Places;
import com.hangouthub.hangouthub.repository.BudgetRepository;
import com.hangouthub.hangouthub.repository.LocationRepository;
import com.hangouthub.hangouthub.repository.MoodRepo;
import com.hangouthub.hangouthub.repository.PlaceRepository;
import com.hangouthub.hangouthub.services.PlaceService;

@Controller
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlaceService placeService;

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private PlaceRepository placeRepo;

    @Autowired
    private MoodRepo moodRepo;

    @Autowired
    private BudgetRepository budgetRepo;

    @GetMapping
    public String showPlanPage(Model model) {
        model.addAttribute("moods", moodRepo.findAll());
        model.addAttribute("places", Collections.emptyList()); 
        model.addAttribute("locations", locationRepo.findDistinctLocation());
        model.addAttribute("budgets", budgetRepo.findAll()); // Make sure you have a method to get budgets
        return "plan";
    }

    @PostMapping
    public String searchByFilters(
            @RequestParam(value = "mood", required = false) List<Long> mood,
            @RequestParam("location") Long location,
            @RequestParam(value = "budget", required = false) Long budget,
            @RequestParam(value = "latitude", required = false) Double latitude,
            @RequestParam(value = "longitude", required = false) Double longitude,
            Model model) {

        List<Places> filteredPlaces = new ArrayList<>();

        if (latitude != null && longitude != null) {
            Optional<Locations> loc = locationRepo.findByLatitudeAndLongitude(latitude, longitude);
            if (loc.isPresent()) {
                filteredPlaces = placeRepo.findByLocations(loc.get());
            }
        } else {
            filteredPlaces = placeService.getPlacesByFilters(mood, location, budget);
        }

        model.addAttribute("places", filteredPlaces);
        model.addAttribute("moods", moodRepo.findAll());
        model.addAttribute("locations", locationRepo.findDistinctLocation());
        model.addAttribute("budgets", budgetRepo.findAll());

        return "plan";
    }

}