package com.trabalho.um.domain.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class CityJPA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private double cost;
  @OneToMany(mappedBy = "city")
  private List<PromotionJPA> promotions;

  public CityJPA(String name, double cost) {
    this.name = name;
    this.cost = cost;
  }

  protected CityJPA() {

  }

  public String getName()
  {
      return this.name;
  }

  public double getCost()
  {
      return this.cost;
  } 
}
