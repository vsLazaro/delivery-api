package com.trabalho.um.Service;
import java.util.List;

import com.trabalho.um.DTO.CreatePromotionDTO;
import com.trabalho.um.domain.model.City;
import com.trabalho.um.domain.model.Promotion;

public interface IPromotionService {
    public Promotion createPromotion(CreatePromotionDTO promotionDTO) throws Exception;
    public Promotion hasPromotion(City city);
    public List<Promotion> getValidPromotions();
}
