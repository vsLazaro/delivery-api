package com.trabalho.um.domain.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BudgetMemoryRepository implements IBudgetRepository {
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
                budget.setName(updatedBudget.getName());
                budget.setValue(updatedBudget.getValue());
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

    @Override
    public City getCityByName(String name) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getCityByName'");
    }
}
