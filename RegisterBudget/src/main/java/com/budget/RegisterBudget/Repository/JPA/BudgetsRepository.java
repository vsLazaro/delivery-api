package com.budget.RegisterBudget.Repository.JPA;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.budget.RegisterBudget.Repository.IBudgetRepository;
import com.budget.RegisterBudget.domain.entity.BudgetJPA;

@Component
public class BudgetsRepository implements IBudgetRepository {

  BudgetsRepositoryJPA budgetsRepositoryJPA;

  public BudgetsRepository(BudgetsRepositoryJPA budgetsRepositoryJPA) {
    this.budgetsRepositoryJPA = budgetsRepositoryJPA;
  }

  @Override
  public void createBudget(BudgetJPA budget) {
    this.budgetsRepositoryJPA.save(budget);
  }

  @Override
  public List<BudgetJPA> getAllBudgets() {
    return this.budgetsRepositoryJPA.findAll();
  }

  @Override
  public List<BudgetJPA> getBudgetByDate(LocalDate date) {
    return this.budgetsRepositoryJPA.findByDate(date);
  }
  
}
