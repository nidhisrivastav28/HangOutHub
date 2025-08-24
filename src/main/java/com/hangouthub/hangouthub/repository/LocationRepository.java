package com.hangouthub.hangouthub.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Locations;
 
@Repository
public interface LocationRepository extends JpaRepository<Locations, Long>{
    Optional<Locations> findByLatitudeAndLongitude(double latitude, double longitude);
    
} 