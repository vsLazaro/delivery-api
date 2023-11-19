package com.trabalho.um.domain.entity;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "budget")
public class BudgetJPA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private LocalDate date;
  private String originCity;
  private String destinyCity;
  private int weight;
  private double basicCost;
  private double adicionalCost;
  private double taxCost;
  private double discount;
  private double totalCost;

  public BudgetJPA(LocalDate date, String originCity, String destinyCity, int weight, double basicCost,
  double adicionalCost, double taxCost, double discount) {
    this.date = date;
    this.originCity = originCity;
    this.destinyCity = destinyCity;
    this.weight = weight;
    this.basicCost = basicCost;
    this.adicionalCost = adicionalCost;
    this.taxCost = taxCost;
    this.discount = discount;
    this.totalCost = this.basicCost + this.adicionalCost + this.taxCost - this.discount;
  }

  protected BudgetJPA() {

  }

  public double getTotalCost() {
    return this.totalCost;
  }

  public int getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getOriginCity() {
    return originCity;
  }

  public String getDestinyCity() {
    return destinyCity;
  }

  public int getWeight() {
    return weight;
  }

  public double getBasicCost() {
    return basicCost;
  }

  public double getAdicionalCost() {
    return adicionalCost;
  }

  public double getTaxCost() {
    return taxCost;
  }

  public double getDiscount() {
    return discount;
  }
}