package com.hangouthub.hangouthub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String placeName;     // Place ka naam
    private Long moodId;          // Mood foreign key
    private Long locationId;      // Location foreign key
    private Long budgetId;        // Budget foreign key
    private String address;       // Address of place
    private String description;   // Description of place
    private String images;        // Image URL/path
    
    // Default constructor (JPA ke liye zaroori)
    public Places() {}

    // Constructor with fields
    public Places(String placeName, Long moodId, Long locationId, Long budgetId,
                  String address, String description, String images) {
        this.placeName = placeName;
        this.moodId = moodId;
        this.locationId = locationId;
        this.budgetId = budgetId;
        this.address = address;
        this.description = description;
        this.images = images;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public Long getMoodId() {
        return moodId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getImages() {
        return images;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
