package com.trabalho.um.domain.model;

import java.util.Date;

public class Budget {

  private int id;
  private Date date;
  private String originCity;
  private String destinyCity;
  private int weight;
  private double basicCost;
  private double adicionalCost;
  private double taxCost;
  private double discount;
  private double totalCost;

  public Budget(int id, Date date, String originCity, String destinyCity, int weight, double basicCost,
      double adicionalCost, double taxCost, double discount) {
    this.id = id;
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

  public double getTotalCost() {
    return this.totalCost;
  }

  public int getId() {
    return id;
  }

  public Date getDate() {
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
