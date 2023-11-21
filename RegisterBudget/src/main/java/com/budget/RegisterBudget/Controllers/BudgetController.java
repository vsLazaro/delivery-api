package com.budget.RegisterBudget.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.budget.RegisterBudget.DTO.CreateBudgetDTO;
import com.budget.RegisterBudget.Service.IBudgetService;
import com.budget.RegisterBudget.domain.entity.BudgetJPA;




@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private IBudgetService service;

    public BudgetController(IBudgetService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BudgetJPA>> getBudget() {
        return new ResponseEntity<List<BudgetJPA>>(this.service.getAllBudgets(), HttpStatus.OK);
    }

    @GetMapping({"/date/{date}"})
    public ResponseEntity<List<BudgetJPA>> getBudgetByDate(@PathVariable LocalDate date) {
        return new ResponseEntity<List<BudgetJPA>>(this.service.getBudgetByDate(date), HttpStatus.CREATED); 
    }

    @PostMapping
    public ResponseEntity<String> createBudget(@RequestBody CreateBudgetDTO budgetDTO) {
        try {
            BudgetJPA budget = this.service.createBudget(budgetDTO);
            return new ResponseEntity<>(Double.toString(budget.getTotalCost()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
