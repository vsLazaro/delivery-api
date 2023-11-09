package com.trabalho.um.domain.Service;

import org.springframework.stereotype.Service;

import com.trabalho.um.domain.Repository.Budget;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {

    private List<Budget> budgets = new ArrayList<>();
    private int nextId = 1;

    public List<Budget> getAllBudgets() {
        return budgets;
    }

    public Budget getBudgetById(int id) {
        for (Budget budget : budgets) {
            if (budget.getId() == id) {
                return budget;
            }
        }
        return null; 
    }

    public Budget createBudget(Budget budget) {
        budget.setId(nextId++);
        budgets.add(budget);
        return budget;
    }

    public Budget updateBudget(int id, Budget updatedBudget) {
        for (Budget budget : budgets) {
            if (budget.getId() == id) {
                return budget;
            }
        }
        return null; 
    }

    public boolean deleteBudget(int id) {
        Budget budgetToRemove = null;
        for (Budget budget : budgets) {
            if (budget.getId() == id) {
                budgetToRemove = budget;
                break;
            }
        }
        if (budgetToRemove != null) {
            budgets.remove(budgetToRemove);
            return true;
        }
        return false; 
    }
}
