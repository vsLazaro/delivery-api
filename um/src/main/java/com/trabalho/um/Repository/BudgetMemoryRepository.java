package com.trabalho.um.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho.um.domain.model.Budget;
@Component
public class BudgetMemoryRepository implements IBudgetRepository {
    private List<Budget> budgets = new ArrayList<>();

    public List<Budget> getAllBudgets() {
        return budgets;
    }

    public void createBudget(Budget budget) {
        budgets.add(budget);
    }

    @Override
    public Budget getBudgetByDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
        for(Budget budget : this.budgets) {
            if(formatDate.format(date).equals(formatDate.format(budget.getDate()))) {
                return budget;
            }
        }
        return null;
    }
}
