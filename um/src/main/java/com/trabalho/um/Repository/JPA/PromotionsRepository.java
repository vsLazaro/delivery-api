package com.trabalho.um.Repository.JPA;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho.um.Repository.IPromotionRepository;
import com.trabalho.um.domain.entity.PromotionJPA;

@Component
public class PromotionsRepository implements IPromotionRepository {

  PromotionsRepositoryJPA promotionsRepositoryJPA;

  public PromotionsRepository(PromotionsRepositoryJPA promotionsRepositoryJPA) {
    this.promotionsRepositoryJPA = promotionsRepositoryJPA;
  }

  @Override
  public List<PromotionJPA> getAllPromotions() {
    return this.promotionsRepositoryJPA.findAll();
  }

  @Override
  public PromotionJPA createPromotion(PromotionJPA promotion) {
    return this.promotionsRepositoryJPA.save(promotion);
  }

  @Override
  public List<PromotionJPA> getValidPromotions() {
    return this.promotionsRepositoryJPA.findByValid(true);
  }
  
}
