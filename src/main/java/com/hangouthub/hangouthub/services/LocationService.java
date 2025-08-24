package com.hangouthub.hangouthub.services;

import java.util.List;

import com.hangouthub.hangouthub.models.Locations;

public interface LocationService {
    List<Locations> getAllLocations();
    Locations getLocationById(Long id);
    Locations saveLocation(Locations location);
    void deleteLocation(Long id);
}
