package com.hangouthub.hangouthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hangouthub.hangouthub.services.BudgetService;
import com.hangouthub.hangouthub.services.LocationService;
import com.hangouthub.hangouthub.services.MoodService;
import com.hangouthub.hangouthub.services.PlaceService;

@Controller
public class PlaceController {
    @Autowired
    private MoodService moodService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private PlaceService placeService;
    
}
