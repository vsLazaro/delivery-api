package com.trabalho.um.domain.Repository;

import java.util.List;

public interface IPromotionRepository {
  Promotion cadastraPromocao(Promotion promocao);
  List<Promotion> getAllPromotions();
  Promotion getPromotionById(int id);
  Promotion updatePromotion(int id, Promotion promotion);
Boolean deletePromotion(int id);
 
}