package com.trabalho.um.Repository;

import java.time.LocalDate;
import java.util.List;

import com.trabalho.um.domain.entity.BudgetJPA;

public interface IBudgetRepository {
  public void createBudget(BudgetJPA budget);
  public List<BudgetJPA> getAllBudgets();
  public List<BudgetJPA> getBudgetByDate(LocalDate date);
}
