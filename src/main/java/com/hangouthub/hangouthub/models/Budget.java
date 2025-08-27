package com.hangouthub.hangouthub.models;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// table not created
// using @Getter and @Setter for creating getter setter methods automatically
@Entity
@Getter
@Setter
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "budget_range")
    private String range;
    private Float minprice;
    private Float maxprice;

    public Budget() {}

//    public Long getId(){
//        return id;
//    }
//    public String getRange(){
//        return range;
//    }
//    public Float getMinPrice(){
//        return minprice;
//    }
//    public Float getMaxPrice(){
//        return maxprice;
//    }
//
//    public void setId(Long id){
//        this.id=id;
//    }
//    public void setRange(String range){
//        this.range=range;
//    }
//    public void setMinPrice(Float minprice){
//        this.minprice=minprice;
//    }
//    public void setMaxPrice(Float maxprice){
//        this.maxprice=maxprice;
//    }
}
