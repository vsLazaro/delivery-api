package com.trabalho.um.Service;

import java.time.LocalDate;
import java.util.List;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.DTO.CreatePersistentBudgetDTO;
import com.trabalho.um.domain.entity.BudgetJPA;

public interface IBudgetService {
  public List<BudgetJPA> getAllBudgets();
  public CreatePersistentBudgetDTO createBudget(CreateBudgetDTO budgetDTO) throws Exception;
  public List<BudgetJPA> getBudgetByDate(LocalDate date);

}
