package com.trabalho.um.Repository;

import java.util.Date;
import java.util.List;

import com.trabalho.um.domain.model.Budget;
import com.trabalho.um.domain.model.City;

public interface IBudgetRepository {
  public void createBudget(Budget budget);
  public List<Budget> getAllBudgets();
  public Budget getBudgetByDate(Date date);
}
