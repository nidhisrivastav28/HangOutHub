package com.hangouthub.hangouthub.services;

import java.util.List;

import com.hangouthub.hangouthub.models.Places;

public interface PlaceService {
    // for CRUD operations
    Places savePlace(Places place);
    Places updatePlace(Long id, Places place);
    List<Places> getAllPlaces();
    void deletePlaces(Long id);
    Places getPlacesById(Long id);

    //for 3 filters at one go
    List<Places> getPlacesByFilters(Long mood, Long location, Long budget);
}
