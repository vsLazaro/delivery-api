package com.trabalho.um.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotion")
public class PromotionJPA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String description;
  private double basicDiscount = 0;
  private double additionalDiscount = 0;
  @ManyToOne
  @JoinColumn(name = "city_id", nullable = false)
  private CityJPA city;
  private int minWeight;
  private int maxWeight;
  private boolean valid;


  public PromotionJPA(String description, double basicDiscount, double additionalDiscount, CityJPA city, int minWeight,
  int maxWeight) {
    this.description = description;
    this.basicDiscount = basicDiscount;
    this.additionalDiscount = additionalDiscount;
    this.city = city;
    this.minWeight = minWeight;
    this.maxWeight = maxWeight;
    this.valid = true;
  }

  protected PromotionJPA() {

  }

   public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public CityJPA getcity() {
        return this.city;
    }

    public double getBasicDiscount()
    {
        return this.basicDiscount;
    }

    public double getAdditionalDiscount()
    {
        return this.additionalDiscount;
    }

    public int getMinWeight()
    {
        return this.minWeight;
    }

    public int getMaxWeight()
    {
        return this.maxWeight;
    }

    public String getDescription() {
        return this.description;
    }
}
