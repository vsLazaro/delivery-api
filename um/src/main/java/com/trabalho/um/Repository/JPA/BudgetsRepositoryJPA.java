package com.trabalho.um.Repository.JPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trabalho.um.domain.entity.BudgetJPA;

import java.time.LocalDate;


public interface BudgetsRepositoryJPA extends CrudRepository<BudgetJPA, Integer> {
  List<BudgetJPA> findByDate(LocalDate date);
  List<BudgetJPA> findAll();
}
