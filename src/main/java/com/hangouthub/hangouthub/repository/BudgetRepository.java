package com.hangouthub.hangouthub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hangouthub.hangouthub.models.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long>{
     
    Optional<Budget> findByRange(String range);

    Optional<Budget> findByMinpriceAndMaxprice(Float minprice, Float maxprice);

    Optional<Budget> findByMinpriceLessThanEqualAndMaxpriceGreaterThanEqual(Float minprice, Float maxprice);

} 
 