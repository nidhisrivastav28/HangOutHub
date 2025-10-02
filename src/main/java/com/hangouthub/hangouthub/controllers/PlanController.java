package com.hangouthub.hangouthub.controllers;

import com.hangouthub.hangouthub.models.Places;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(value = "mood", required = false) List<Long> moodIds,
            @RequestParam(value = "location", required = false) Long locationId,
            @RequestParam(value = "budget", required = false) Long budgetId,
            @RequestParam(value = "latitude", required = false) Double latitude,
            @RequestParam(value = "longitude", required = false) Double longitude,
            Model model) {

        List<Places> filteredPlaces = new ArrayList<>();

        if (latitude != null && longitude != null) {
            // fetch location within 5km
            filteredPlaces = placeRepo.findPlacesWithinRadius(latitude, longitude, 5);
        } else {
            filteredPlaces = placeService.getPlacesByFilters(moodIds, locationId, budgetId);
        }

        
        if (moodIds != null && !moodIds.isEmpty()) {
            filteredPlaces = filteredPlaces.stream()
                    .filter(p -> moodIds.contains(p.getMood().getId()))
                    .toList();
        }
        if (budgetId != null) {
            filteredPlaces = filteredPlaces.stream()
                    .filter(p -> p.getBudget().getId().equals(budgetId))
                    .toList();
        }

        model.addAttribute("places", filteredPlaces);
        model.addAttribute("moods", moodRepo.findAll());
        model.addAttribute("locations", locationRepo.findDistinctLocation());
        model.addAttribute("budgets", budgetRepo.findAll());

        return "plan";
    }

}