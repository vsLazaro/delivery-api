package com.budget.RegisterBudget.Service;

import java.time.LocalDate;
import java.util.List;

import com.budget.RegisterBudget.DTO.CreateBudgetDTO;
import com.budget.RegisterBudget.domain.entity.BudgetJPA;

public interface IBudgetService {
  public List<BudgetJPA> getAllBudgets();
  public BudgetJPA createBudget(CreateBudgetDTO budgetDTO) throws Exception;
  public List<BudgetJPA> getBudgetByDate(LocalDate date);
}
