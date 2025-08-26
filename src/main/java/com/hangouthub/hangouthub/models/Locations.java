package com.hangouthub.hangouthub.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location_name;
    private Double latitude;
    private Double longitude;

    public Locations() {}

    public Long getId(){
        return id;
    }
    public String getLocationName(){
        return location_name;
    }
    public Double getLatitude(){
        return latitude;
    }
    public Double getLongitude(){
        return longitude;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setLocationName(String location_name){
        this.location_name=location_name;
    }
    public void setLatitude(Double latitude){
        this.latitude=latitude;
    }
    public void setLongitude(Double longitude){
        this.longitude=longitude;
    }
}
