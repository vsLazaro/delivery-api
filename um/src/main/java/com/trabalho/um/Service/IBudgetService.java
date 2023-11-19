package com.trabalho.um.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.domain.entity.BudgetJPA;

public interface IBudgetService {
  public List<BudgetJPA> getAllBudgets();
  public BudgetJPA createBudget(CreateBudgetDTO budgetDTO) throws Exception;
  public List<BudgetJPA> getBudgetByDate(LocalDate date);

}
