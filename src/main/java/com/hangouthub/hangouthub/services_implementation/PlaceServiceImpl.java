package com.hangouthub.hangouthub.services_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangouthub.hangouthub.models.Budget;
import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.models.Places;
import com.hangouthub.hangouthub.repository.BudgetRepository;
import com.hangouthub.hangouthub.repository.LocationRepository;
import com.hangouthub.hangouthub.repository.MoodRepo;
import com.hangouthub.hangouthub.repository.PlaceRepository;
import com.hangouthub.hangouthub.services.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private MoodRepo moodRepo;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Places savePlace(Places place) {
        return placeRepository.save(place);
    }

    @Override
    public Places updatePlace(Long id, Places place) {
        Places existingPlace = placeRepository.findById(id).orElseThrow();
        existingPlace.setPlaceName(place.getPlaceName());
        existingPlace.setMood(place.getMood());
        existingPlace.setLocations(place.getLocations());
        existingPlace.setBudget(place.getBudget());
        existingPlace.setAddress(place.getAddress());
        existingPlace.setDescription(place.getDescription());
        existingPlace.setImages(place.getImages());
        return placeRepository.save(existingPlace);
    }

    @Override
    public List<Places> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public void deletePlaces(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public Places getPlacesById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Places> getPlacesByFilters(Long moodId, Long locationId, Long budgetId) {
        Mood mood = moodRepo.findById(moodId).orElseThrow();
        Locations locations = locationRepository.findById(locationId).orElseThrow();
        Budget budget = budgetRepository.findById(budgetId).orElseThrow();
        
        return placeRepository.findByMoodAndLocationsAndBudget(mood, locations, budget);
//      changed findByMoodAndLocationAndBudget to findByMoodAndLocationsAndBudget
//      dekh ekta extra 's' ache naming e
    }
    
}
