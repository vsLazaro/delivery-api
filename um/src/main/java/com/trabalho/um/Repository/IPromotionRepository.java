package com.trabalho.um.Repository;

import java.util.List;

import com.trabalho.um.domain.entity.PromotionJPA;

public interface IPromotionRepository {
  public List<PromotionJPA> getAllPromotions();
  public PromotionJPA createPromotion(PromotionJPA promotion);
  public List<PromotionJPA> getValidPromotions();
}