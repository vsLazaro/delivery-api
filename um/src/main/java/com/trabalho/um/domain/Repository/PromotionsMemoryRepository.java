package com.trabalho.um.domain.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalho.um.domain.model.Promotion;

@Component
public class PromotionsMemoryRepository implements IPromotionRepository {
  private ArrayList<Promotion> promotions = new ArrayList<>();

  public List<Promotion> getAllPromotions() {
    return promotions;
  }

  @Override
  public Promotion createPromotion(Promotion promocao) {
    promotions.add(promocao);
    return promocao;
  }

  @Override
  public List<Promotion> getValidPromotions() {
    List<Promotion> promotions = new ArrayList<Promotion>();
    for(Promotion promotion : this.promotions) {
      if(promotion.isValid()) {
        promotions.add(promotion);
      }
    }
    return promotions;
  }
}