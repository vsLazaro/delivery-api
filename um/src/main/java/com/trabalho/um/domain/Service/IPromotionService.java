package com.trabalho.um.domain.Service;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.trabalho.um.domain.Repository.Promotion;

public interface IPromotionService {
    Promotion cadastraPromocao(Promotion promocao);   
    List<Promotion> getAllPromotions();
    Promotion getPromotionById(@PathVariable int id);
    Boolean deletePromotion(int id);
}
