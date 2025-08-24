package com.hangouthub.hangouthub.services;

import java.util.List;
import java.util.Optional;

import com.hangouthub.hangouthub.models.Budget;

public interface BudgetService {
    List<Budget> getAllBudgets();
    Optional<Budget> getBudgetById(Long id);
    Budget saveBudget(Budget budget);
    void deleteBudget(Long id);
    Optional<Budget> findByBudgetRange(String budgetRange);
}
 