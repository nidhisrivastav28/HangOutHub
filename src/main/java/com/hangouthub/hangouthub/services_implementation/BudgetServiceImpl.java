package com.hangouthub.hangouthub.services_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangouthub.hangouthub.models.Budget;
import com.hangouthub.hangouthub.repository.BudgetRepository;
import com.hangouthub.hangouthub.services.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService{
    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    @Override
    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    @Override
    public Optional<Budget> findByBudgetRange(String budgetRange) {
        return budgetRepository.findByRange(budgetRange);
    }

}
