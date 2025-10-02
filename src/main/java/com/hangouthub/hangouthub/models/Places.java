package com.hangouthub.hangouthub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String placeName;     
    @ManyToOne
    @JoinColumn(name = "mood_id")
    private Mood mood;         
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;      
    
    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;        
    private String address;       
    private String description;   
    private String images;        
    
    // Default constructor (imp for JPA)
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
}
