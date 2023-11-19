package com.trabalho.um.Service;

import java.util.Date;
import java.util.List;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.domain.model.Budget;

public interface IBudgetService {
  public List<Budget> getAllBudgets();
  public Budget createBudget(CreateBudgetDTO budgetDTO) throws Exception;
  public Budget getBudgetByDate(Date date);

}
