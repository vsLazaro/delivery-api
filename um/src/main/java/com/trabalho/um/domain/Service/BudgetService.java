package com.trabalho.um.domain.Service;

import org.springframework.stereotype.Service;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.domain.Repository.IBudgetRepository;
import com.trabalho.um.domain.model.Budget;
import com.trabalho.um.domain.model.City;
import com.trabalho.um.domain.model.Promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BudgetService {

    private int nextId = 1;
    private ICityService cityService;
    private IBudgetRepository budgetRepository;

    private final String PRINCIPAL_CITY = "São Paulo";
    private IPromotionService promotionService;

    public BudgetService(ICityService cityService, IBudgetRepository budgetRepository, IPromotionService promotionService) {
        this.cityService = cityService;
        this.budgetRepository = budgetRepository;
        this.promotionService = promotionService;
    }

    public List<Budget> getAllBudgets() {
      return this.budgetRepository.getAllBudgets();
    }

    public Budget createBudget(CreateBudgetDTO budgetDTO) throws Exception {
        try {
            City originCity = this.cityService.getCityByCep(budgetDTO.cepOrigin);
            City destinCity = this.cityService.getCityByCep(budgetDTO.cepDestiny);
            Date date = new Date();

            double basicCost = this.calculateBasicCost(originCity, destinCity);
            int weight = this.transformMgToKg(budgetDTO.weight);
            int adicionalCost = this.calculateAdicionalCostByweight(weight, 0);
            double taxCost = this.calculateTaxCost(originCity, destinCity, basicCost);
            Promotion promotion = this.getPromotion(originCity);
            int id = nextId;
            nextId++;
            double discount = 0.0;
            if(promotion != null && weight >= promotion.getMinWeight() && weight <= promotion.getMaxWeight()) {
              discount += promotion.getBasicDiscount() + promotion.getAdditionalDiscount();
            }
            
            Budget budget = new Budget(id, date, originCity.getName(), destinCity.getName(), weight, basicCost, adicionalCost, taxCost, discount);
            this.budgetRepository.createBudget(budget);
            return budget;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Promotion getPromotion(City originCity) {
      Promotion promotion = this.promotionService.hasPromotion(originCity);
      return promotion;
    }

    private double calculateBasicCost(City originCity, City destinCity) 
    {
        if (
          destinCity.getName().equals(this.PRINCIPAL_CITY) ||
          originCity.getName().equals(destinCity.getName())
        ) {
          return originCity.getCost();
        }
        if (originCity.getName().equals(this.PRINCIPAL_CITY)) {
          return destinCity.getCost();
        }
        return originCity.getCost() + destinCity.getCost();
    }

    private int transformMgToKg(int weight) {
        return Math.round(weight / 1000);
    }

    private int calculateAdicionalCostByweight(int weight, int adicionalCost) {
        if (weight >= 12) {
          adicionalCost += 15;
          weight--;
          this.calculateAdicionalCostByweight(weight, adicionalCost);
        }
        if (weight >= 3) {
          adicionalCost += 10;
          weight--;
          this.calculateAdicionalCostByweight(weight, adicionalCost);
        }
        return adicionalCost;
    }

    private double calculateTaxCost(City originCity, City destinyCity, double basicCost) {
        if (originCity.getName().equals(destinyCity.getName())) {
          return 0.05 * basicCost;
        }
        if(originCity.getName().equals(PRINCIPAL_CITY) || destinyCity.getName().equals(PRINCIPAL_CITY)) {
          return 0.05 * originCity.getCost();
        }
        return 0.05 * originCity.getCost() + 0.05 * originCity.getCost();
    }

    public Budget getBudgetByDate(Date date) {
      return this.budgetRepository.getBudgetByDate(date);
    }
}
