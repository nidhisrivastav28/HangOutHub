package com.hangouthub.hangouthub.services_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangouthub.hangouthub.models.Places;
import com.hangouthub.hangouthub.repository.PlaceRepository;
import com.hangouthub.hangouthub.services.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Places savePlace(Places place) {
        return placeRepository.save(place);
    }

    @Override
    public Places updatePlace(Long id, Places place) {
        Places existingPlace = placeRepository.findById(id).orElseThrow();
        existingPlace.setPlaceName(place.getPlaceName());
        existingPlace.setMoodId(place.getMoodId());
        existingPlace.setLocationId(place.getLocationId());
        existingPlace.setBudgetId(place.getBudgetId());
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
        return placeRepository.findByMoodIdAndLocationIdAndBudgetId(moodId, locationId, budgetId);
    }
    
}
