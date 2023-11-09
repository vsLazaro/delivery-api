package com.trabalho.um.domain.Repository;

import java.util.Date;

public class Budget {

  private int id;
  private Date date;
  private City originCity;
  private City destinyCity;
  private int weight;
  private double basicCost;
  private double adicionalCost;
  private double taxCost;
  private double discount;
  private final String PRINCIPAL_CITY = "São Paulo";

  public Budget(int id, Date date, City originCity, City destinyCity, int weight, double discount) {
    this.id = id;
    this.date = date;
    this.originCity = originCity;
    this.destinyCity = destinyCity;
    weight = this.transformMgToKg(weight);
    this.weight = weight;
    this.discount = discount;
    this.calculateAdicionalCostByweight(this.weight);
    this.calculateBasicCost();
    this.calculateTaxCost();

  }

  public void calculateBasicCost() {
    if (
      this.destinyCity.getName().equals(this.PRINCIPAL_CITY) ||
      this.originCity.getName().equals(this.destinyCity.getName())
    ) {
      this.basicCost = this.originCity.getCost();
      return;
    }
    if (this.originCity.getName().equals(this.PRINCIPAL_CITY)) {
      this.basicCost = this.destinyCity.getCost();
      return;
    }
    this.basicCost = this.originCity.getCost() + this.destinyCity.getCost();
  }

  public void calculateAdicionalCostByweight(int weight) {
    if (weight >= 12) {
      this.adicionalCost += 15;
      weight--;
      this.calculateAdicionalCostByweight(weight);
    }
    if (weight >= 3) {
      this.adicionalCost += 10;
      weight--;
      this.calculateAdicionalCostByweight(weight);
    }
    this.adicionalCost += 0;
  }

  public void calculateTaxCost() {
    if (this.originCity.getName().equals(this.destinyCity.getName())) {
      this.taxCost = 0.05 * this.basicCost;
    } else if(this.originCity.getName().equals(PRINCIPAL_CITY)) {
      this.taxCost = 0.05 * originCity.getCost();
    } else if(this.destinyCity.getName().equals(PRINCIPAL_CITY)) {
      this.taxCost = 0.05 * destinyCity.getCost();
    } else {
      this.taxCost = 0.05 * originCity.getCost() + 0.05 * destinyCity.getCost();
    }
  }

  private int transformMgToKg(int weight) {
    return Math.round(weight / 1000);
  }

  public double getFinalCost() {
    return 0.0;
  }

  public int getId(){
    return id;
  }
  
  public void setId(int i){
    this.id = id;
  }

public Object getName() {
    return null;
}

public Object getValue() {
    return null;
}

public void setName(Object name) {
}

public void setValue(Object value) {
}

}
