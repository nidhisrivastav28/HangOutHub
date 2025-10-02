package com.hangouthub.hangouthub.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Budget;
import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.models.Places;

@Repository
public interface PlaceRepository extends JpaRepository<Places, Long> {
    List<Places> findByLocations(Locations locations);

    // same here findByLocation to findByLocations
    // extra 's' for plural naming
    // multiple moods + location + budget
    @Query("SELECT p FROM Places p WHERE p.mood IN :moods AND p.locations = :locations AND p.budget = :budget")
    List<Places> findByMoodsInAndLocationsAndBudget(List<Mood> moods, Locations locations, Budget budget);

    // multiple moods + location (budget optional case)
    @Query("SELECT p FROM Places p WHERE p.mood IN :moods AND p.locations = :locations")
    List<Places> findByMoodsInAndLocations(List<Mood> moods, Locations locations);

    @Query("SELECT p FROM Places p WHERE p.locations = :locations AND p.budget = :budget")
    List<Places> findByLocationsAndBudget(Locations locations, Budget budget);
    // same here findByMoodAndLocationAndBudget to findByMoodAndLocationsAndBudget
    // extra 's' for plural naming

    @Query("SELECT p FROM Places p WHERE p.mood = :mood")
    List<Places> findByMood(Mood mood);

    // Harvesine Formula
    @Query("SELECT p FROM Places p WHERE " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(p.locations.latitude)) * " +
            "cos(radians(p.locations.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(p.locations.latitude)))) <= :radiusKm")
    List<Places> findPlacesWithinRadius(
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("radiusKm") double radiusKm);

}
