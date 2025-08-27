package com.hangouthub.hangouthub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String placeName;     // Place ka naam
    @ManyToOne
    @JoinColumn(name = "mood_id")
    private Mood mood;          // Mood foreign key
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;      // Locations foreign key
    
    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;        // Budget foreign key
    private String address;       // Address of place
    private String description;   // Description of place
    private String images;        // Image URL/path
    
    // Default constructor (JPA ke liye zaroori)
    public Places() {}

    // Constructor with fields
    public Places(String placeName, Mood mood, Locations locations, Budget budget,
                  String address, String description, String images) {
        this.placeName = placeName;
        this.mood = mood;
        this.locations = locations;
        this.budget = budget;
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

    public Mood getMood() {
        return mood;
    }

    public Locations getLocation() {
        return locations;
    }

    public Budget getBudget() {
        return budget;
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

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setLocation(Locations locations) {
        this.locations = locations;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
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
