package com.trabalho.um.Service;

import org.aspectj.internal.lang.annotation.ajcDeclarePrecedence;
import org.springframework.stereotype.Service;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.DTO.CreatePersistentBudgetDTO;
import com.trabalho.um.Repository.IBudgetRepository;
import com.trabalho.um.domain.entity.BudgetJPA;
import com.trabalho.um.domain.entity.CityJPA;
import com.trabalho.um.domain.entity.PromotionJPA;

import java.time.LocalDate;
import java.util.List;

@Service
public class BudgetService implements IBudgetService {
    private ICityService cityService;
    private IBudgetRepository budgetRepository;

    private final String PRINCIPAL_CITY = "São Paulo";
    private IPromotionService promotionService;

    public BudgetService(ICityService cityService, IBudgetRepository budgetRepository, IPromotionService promotionService) {
        this.cityService = cityService;
        this.budgetRepository = budgetRepository;
        this.promotionService = promotionService;
    }

    public List<BudgetJPA> getAllBudgets() {
      return this.budgetRepository.getAllBudgets();
    }

    public CreatePersistentBudgetDTO createBudget(CreateBudgetDTO budgetDTO) throws Exception {
        try {
            CityJPA originCity = this.cityService.getCityByCep(budgetDTO.cepOrigin);
            CityJPA destinCity = this.cityService.getCityByCep(budgetDTO.cepDestiny);
            LocalDate date = LocalDate.now();

            double basicCost = this.calculateBasicCost(originCity, destinCity);
            int weight = this.transformMgToKg(budgetDTO.weight);
            int adicionalCost = this.calculateAdicionalCostByweight(weight, 0);
            double taxCost = this.calculateTaxCost(originCity, destinCity, basicCost);
            PromotionJPA promotion = this.getPromotion(originCity);
            double discount = 0.0;
            if(promotion != null && weight >= promotion.getMinWeight() && weight <= promotion.getMaxWeight()) {
              discount += promotion.getBasicDiscount() + promotion.getAdditionalDiscount();
            }
            
            double totalCost = basicCost + adicionalCost + taxCost - discount;
            CreatePersistentBudgetDTO budget = new CreatePersistentBudgetDTO(date.toString(), originCity.getName(), destinCity.getName(), weight, basicCost, adicionalCost, taxCost, discount, totalCost);
            this.budgetRepository.createBudget(budget);
            return budget;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private PromotionJPA getPromotion(CityJPA originCity) {
      PromotionJPA promotion = this.promotionService.hasPromotion(originCity);
      return promotion;
    }

    private double calculateBasicCost(CityJPA originCity, CityJPA destinCity) 
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

    private double calculateTaxCost(CityJPA originCity, CityJPA destinyCity, double basicCost) {
        if (originCity.getName().equals(destinyCity.getName())) {
          return 0.05 * basicCost;
        }
        if(originCity.getName().equals(PRINCIPAL_CITY) || destinyCity.getName().equals(PRINCIPAL_CITY)) {
          return 0.05 * originCity.getCost();
        }
        return 0.05 * originCity.getCost() + 0.05 * originCity.getCost();
    }

    public List<BudgetJPA> getBudgetByDate(LocalDate date) {
      return this.budgetRepository.getBudgetByDate(date);
    }
}
