package com.trabalho.um.Service;
import java.util.List;

import com.trabalho.um.DTO.CreatePromotionDTO;
import com.trabalho.um.domain.entity.CityJPA;
import com.trabalho.um.domain.entity.PromotionJPA;

public interface IPromotionService {
    public PromotionJPA createPromotion(CreatePromotionDTO promotionDTO) throws Exception;
    public PromotionJPA hasPromotion(CityJPA city);
    public List<PromotionJPA> getValidPromotions();
}
