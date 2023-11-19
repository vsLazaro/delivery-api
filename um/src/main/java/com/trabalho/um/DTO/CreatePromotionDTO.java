package com.trabalho.um.DTO;

import com.trabalho.um.domain.model.City;

public class CreatePromotionDTO {
  public String description;
  public double basicDiscount;
  public double additionalDiscount;
  public String city;
  public int minWeight;
  public int maxWeight;
  public boolean valid;
}
