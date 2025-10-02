package com.hangouthub.hangouthub.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location_name;
    private Double latitude;
    private Double longitude;

    public Locations() {}

}
