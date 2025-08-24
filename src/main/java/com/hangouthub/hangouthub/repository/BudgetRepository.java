package com.hangouthub.hangouthub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long>{
     // range (string) se find karne ke liye
    Optional<Budget> findByRange(String range);

    // minprice aur maxprice dono match karne ke liye
    Optional<Budget> findByMinpriceAndMaxprice(Float minprice, Float maxprice);

    // koi amount kisi budget range me aata hai ya nahi
    Optional<Budget> findByMinpriceLessThanEqualAndMaxpriceGreaterThanEqual(Float minprice, Float maxprice);

} 
 