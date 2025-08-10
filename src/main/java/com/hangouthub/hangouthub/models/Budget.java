package com.hangouthub.hangouthub.models;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// table not created
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer range;
    private Float minprice;
    private Float maxprice;

    public Budget() {}

    public Long getId(){
        return id;
    }
    public Integer getRange(){
        return range;
    }
    public Float getMinPrice(){
        return minprice;
    }
    public Float getMaxPrice(){
        return maxprice;
    }

    public void setId(Long id){
        this.id=id;
    }
    public void setRange(Integer range){
        this.range=range;
    }
    public void setMinPrice(Float minprice){
        this.minprice=minprice;
    }
    public void setMaxPrice(Float maxprice){
        this.maxprice=maxprice;
    }
}
