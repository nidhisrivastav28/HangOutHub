package com.hangouthub.hangouthub.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Budget;
import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.models.Places;

@Repository
public interface PlaceRepository extends JpaRepository<Places,Long> {
    List<Places> findByLocations(Locations locations);
    // same here findByLocation to findByLocations
    // extra 's' for plural naming


    @Query("SELECT p FROM Places p WHERE p.mood = :mood AND p.locations = :locations AND p.budget = :budget")
    List<Places> findByMoodAndLocationsAndBudget(Mood mood, Locations locations, Budget budget);
    // same here findByMoodAndLocationAndBudget to findByMoodAndLocationsAndBudget
    // extra 's' for plural naming

}
