package com.trabalho.um.domain.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PromotionsMemoryRepository implements IPromotionRepository {
  private ArrayList<Promotion> promotions = new ArrayList<>();

  public PromotionsMemoryRepository()
  {
    Promotion promotion1 = new Promotion("Promotion 1", 0, 0, null, 0, 0, 0);
    Promotion promotion2 = new Promotion("Promotion 2", 0, 0, null, 0, 0, 0);
    this.promotions.add(promotion1);
    this.promotions.add(promotion2);
  }

  public List<Promotion> getAllPromotions() {
    return promotions;
  }

  @Override
  public Promotion cadastraPromocao(Promotion promocao) {
    promotions.add(promocao);
    return promocao;
  }

  public Promotion getPromotionById(int id) {
    for(Promotion promotion : promotions) {
      if(promotion.getId() == id) {
        return promotion;
      }
    }
    return null;
  }

  public Promotion updatePromotion(int id, Promotion promotion) {
    for(int i = 0; i < promotions.size(); i++) {
      if(promotions.get(i).getId() == id) {
        promotions.set(i, promotion);
        return promotion;
      }
    }
    return null;
  }

  @Override
  public Boolean deletePromotion(int id) {
    Promotion promotionToRemove = null;
    for (Promotion promotion : promotions) {
      if (promotion.getId() == id) {
        promotionToRemove = promotion;
      }
    }
    if (promotionToRemove != null) {
      promotions.remove(promotionToRemove);
      return true;
    }
    return false;
  }
}