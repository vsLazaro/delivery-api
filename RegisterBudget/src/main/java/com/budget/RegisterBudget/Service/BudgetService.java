package com.budget.RegisterBudget.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.budget.RegisterBudget.DTO.CreateBudgetDTO;
import com.budget.RegisterBudget.Repository.IBudgetRepository;
import com.budget.RegisterBudget.domain.entity.BudgetJPA;


@Service
public class BudgetService implements IBudgetService {

    private IBudgetRepository budgetRepository;

    public BudgetService(IBudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetJPA> getAllBudgets() {
        return this.budgetRepository.getAllBudgets();
    }

    @Override
    public BudgetJPA createBudget(CreateBudgetDTO budgetDTO) throws Exception {
        try {
            BudgetJPA budget = new BudgetJPA(budgetDTO.date, budgetDTO.originCity, budgetDTO.destinyCity, budgetDTO.weight, budgetDTO.basicCost, budgetDTO.adicionalCost, budgetDTO.taxCost, budgetDTO.discount);
            return budget;
        } catch (Exception e) {
            throw new Exception("Error creating budget");
        }
    }

    @Override
    public List<BudgetJPA> getBudgetByDate(LocalDate date) {
        return this.budgetRepository.getBudgetByDate(date);
    }

}
