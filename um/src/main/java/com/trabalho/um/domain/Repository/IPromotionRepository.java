package com.trabalho.um.domain.Repository;

import java.util.List;

import com.trabalho.um.domain.model.Promotion;

public interface IPromotionRepository {
  public List<Promotion> getAllPromotions();
  public Promotion createPromotion(Promotion promocao);
  public List<Promotion> getValidPromotions();
}