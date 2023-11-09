package com.trabalho.um.domain.Service;

import com.trabalho.um.domain.Repository.IPromotionRepository;
import com.trabalho.um.domain.Repository.Promotion;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {

    private IPromotionRepository promotionRepository;

    public PromotionService(IPromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion cadastraPromocao(Promotion promocao) {
        return promotionRepository.cadastraPromocao(promocao);
    }

    public Promotion getPromotionById(int id) {
        return promotionRepository.getPromotionById(id);
    }

    public List<Promotion> getAllPromotions(){
        return promotionRepository.getAllPromotions();
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.cadastraPromocao(promotion);
    }


    public Promotion updatePromotion(int id, Promotion promotion) {
        return promotionRepository.updatePromotion(id, promotion);
    }

    @Override
    public Boolean deletePromotion(int id) {
        return promotionRepository.deletePromotion(id);
    }
}