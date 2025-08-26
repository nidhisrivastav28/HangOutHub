package com.hangouthub.hangouthub.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Budget;
import com.hangouthub.hangouthub.models.Locations;
import com.hangouthub.hangouthub.models.Mood;
import com.hangouthub.hangouthub.models.Places;

@Repository
public interface PlaceRepository extends JpaRepository<Places,Long> {
    List<Places> findByLocation(Locations locations);

    List<Places> findByMoodAndLocationAndBudget(Mood mood, Locations locations, Budget budget);

}
