package com.budget.RegisterBudget.Repository.JPA;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budget.RegisterBudget.domain.entity.BudgetJPA;

public interface BudgetsRepositoryJPA extends CrudRepository<BudgetJPA, Integer> {
  List<BudgetJPA> findByDate(LocalDate date);
  List<BudgetJPA> findAll();
}