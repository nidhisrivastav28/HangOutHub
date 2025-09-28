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
public class PlaceServiceImpl implements PlaceService {
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
    public List<Places> getPlacesByFilters(List<Long> moodId, Long locationId, Long budgetId) {

        Locations locations = locationRepository.findById(locationId).orElseThrow();
        Budget budget = (budgetId != null) ? budgetRepository.findById(budgetId).orElse(null) : null;

        List<Mood> mood = (moodId != null && !moodId.isEmpty()) ? moodRepo.findAllById(moodId) : null;

        if ((mood != null) && (budget != null)) {
            return placeRepository.findByMoodsInAndLocationsAndBudget(mood, locations, budget);
        }else if(mood != null){
            return placeRepository.findByMoodsInAndLocations(mood, locations);
        }else if(budget != null){
            return placeRepository.findByLocationsAndBudget(locations, budget);
        }else{
            // agar budget optional hai to without budget bhi query chale
            return placeRepository.findByLocations(locations);
        }

        // sreturn placeRepository.findByMoodAndLocationsAndBudget(mood, locations, budget);
        // changed findByMoodAndLocationAndBudget to findByMoodAndLocationsAndBudget
        // dekh ekta extra 's' ache naming e
    }

}
