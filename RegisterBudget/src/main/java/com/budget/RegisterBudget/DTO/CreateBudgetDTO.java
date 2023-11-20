package com.budget.RegisterBudget.DTO;

import java.time.LocalDate;

public class CreateBudgetDTO {
  public LocalDate date;
  public String originCity;
  public String destinyCity;
  public int weight;
  public double basicCost;
  public double adicionalCost;
  public double taxCost;
  public double discount;
  public double totalCost;
}
