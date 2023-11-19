package com.trabalho.um.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trabalho.um.DTO.CreatePromotionDTO;
import com.trabalho.um.Service.IPromotionService;
import com.trabalho.um.domain.model.Promotion;


import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private IPromotionService promotionService;

    public PromotionController(IPromotionService promotionService) {
        this.promotionService = promotionService;
    }

     @GetMapping({"/valid"})
    public ResponseEntity<List<Promotion>> cepIsServed()
    {
        return new ResponseEntity<List<Promotion>>(this.promotionService.getValidPromotions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody CreatePromotionDTO promotion) {
        try {
            Promotion createdPromotion = promotionService.createPromotion(promotion);
            return new ResponseEntity<>(createdPromotion, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
