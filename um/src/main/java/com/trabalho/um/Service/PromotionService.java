package com.trabalho.um.Service;

import com.trabalho.um.DTO.CreatePromotionDTO;
import com.trabalho.um.Repository.IPromotionRepository;
import com.trabalho.um.domain.entity.CityJPA;
import com.trabalho.um.domain.entity.PromotionJPA;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {

    private IPromotionRepository promotionRepository;
    private ICityService cityService;

    public PromotionService(IPromotionRepository promotionRepository, ICityService cityService) {
        this.promotionRepository = promotionRepository;
        this.cityService = cityService;
    }

    public PromotionJPA createPromotion(CreatePromotionDTO promotionDTO) throws Exception {
        try {
            CityJPA city = this.cityService.geCityByName(promotionDTO.city);
            PromotionJPA promotion = new PromotionJPA(promotionDTO.description, promotionDTO.basicDiscount, promotionDTO.additionalDiscount, city, promotionDTO.minWeight, promotionDTO.maxWeight);
            return promotionRepository.createPromotion(promotion);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public PromotionJPA hasPromotion(CityJPA city) {
        for(PromotionJPA promotion : this.promotionRepository.getAllPromotions()) {
            if(promotion.getcity().getName() == city.getName() && promotion.isValid()) {
                return promotion;
            }
        }
        return null;
    }

    public List<PromotionJPA> getValidPromotions() {
      return this.promotionRepository.getValidPromotions();
    }
}