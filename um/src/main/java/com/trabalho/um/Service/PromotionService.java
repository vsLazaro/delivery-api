package com.trabalho.um.Service;

import com.trabalho.um.DTO.CreatePromotionDTO;
import com.trabalho.um.Repository.IPromotionRepository;
import com.trabalho.um.domain.model.City;
import com.trabalho.um.domain.model.Promotion;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {

    private IPromotionRepository promotionRepository;
    private ICityService cityService;

    private int id = 1;

    public PromotionService(IPromotionRepository promotionRepository, ICityService cityService) {
        this.promotionRepository = promotionRepository;
        this.cityService = cityService;
    }

    public Promotion createPromotion(CreatePromotionDTO promotionDTO) throws Exception {
        try {
            City city = this.cityService.geCityByName(promotionDTO.city);
            int id = this.id;
            this.id++;
            Promotion promotion = new Promotion(promotionDTO.description, promotionDTO.basicDiscount, promotionDTO.additionalDiscount, city, promotionDTO.minWeight, promotionDTO.maxWeight, id);
            return promotionRepository.createPromotion(promotion);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Promotion hasPromotion(City city) {
        for(Promotion promotion : this.promotionRepository.getAllPromotions()) {
            if(promotion.getcity().getName() == city.getName() && promotion.isValid()) {
                return promotion;
            }
        }
        return null;
    }

    public List<Promotion> getValidPromotions() {
      return this.promotionRepository.getValidPromotions();
    }
}