package com.hangouthub.hangouthub.services_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.repository.LocationRepository;
import com.hangouthub.hangouthub.services.LocationService;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Locations> getAllLocations(){
        return locationRepository.findAll();
    }
    @Override
    public Locations getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }
    @Override
    public Locations saveLocation(Locations location) {
        return locationRepository.save(location);    
    }
    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
