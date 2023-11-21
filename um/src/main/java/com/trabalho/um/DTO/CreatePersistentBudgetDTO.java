package com.trabalho.um.DTO;

import java.time.LocalDate;

public class CreatePersistentBudgetDTO {
  private String date;
  private String originCity;
  private String destinyCity;
  private int weight;
  private double basicCost;
  private double adicionalCost;
  private double taxCost;
  private double discount;
  private double totalCost;

  public CreatePersistentBudgetDTO(String date, String originCity, String destinyCity, int weight, double basicCost,
      double adicionalCost, double taxCost, double discount, double totalCost) {
    this.date = date;
    this.originCity = originCity;
    this.destinyCity = destinyCity;
    this.weight = weight;
    this.basicCost = basicCost;
    this.adicionalCost = adicionalCost;
    this.taxCost = taxCost;
    this.discount = discount;
    this.totalCost = totalCost;
  }
 

  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getOriginCity() {
    return originCity;
  }
  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }
  public String getDestinyCity() {
    return destinyCity;
  }
  public void setDestinyCity(String destinyCity) {
    this.destinyCity = destinyCity;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public double getBasicCost() {
    return basicCost;
  }
  public void setBasicCost(double basicCost) {
    this.basicCost = basicCost;
  }
  public double getAdicionalCost() {
    return adicionalCost;
  }
  public void setAdicionalCost(double adicionalCost) {
    this.adicionalCost = adicionalCost;
  }
  public double getTaxCost() {
    return taxCost;
  }
  public void setTaxCost(double taxCost) {
    this.taxCost = taxCost;
  }
  public double getDiscount() {
    return discount;
  }
  public void setDiscount(double discount) {
    this.discount = discount;
  }
  public double getTotalCost() {
    return totalCost;
  }
  public void setTotalCost(double totalCost) {
    this.totalCost = totalCost;
  }
}
