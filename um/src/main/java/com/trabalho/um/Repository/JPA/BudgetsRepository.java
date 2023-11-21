package com.trabalho.um.Repository.JPA;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho.um.DTO.CreatePersistentBudgetDTO;
import com.trabalho.um.Repository.IBudgetRepository;
import com.trabalho.um.domain.entity.BudgetJPA;


public class BudgetsRepository implements IBudgetRepository {

  BudgetsRepositoryJPA budgetsRepositoryJPA;

  public BudgetsRepository(BudgetsRepositoryJPA budgetsRepositoryJPA) {
    this.budgetsRepositoryJPA = budgetsRepositoryJPA;
  }

  @Override
  public List<BudgetJPA> getAllBudgets() {
    return this.budgetsRepositoryJPA.findAll();
  }

  @Override
  public List<BudgetJPA> getBudgetByDate(LocalDate date) {
    return this.budgetsRepositoryJPA.findByDate(date);
  }

  @Override
  public void createBudget(CreatePersistentBudgetDTO budget) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createBudget'");
  }
  
}
