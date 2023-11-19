package com.trabalho.um.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.DTO.ReadBudgetByDateDTO;
import com.trabalho.um.domain.Service.BudgetService;
import com.trabalho.um.domain.model.Budget;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private BudgetService service;

    public BudgetController(BudgetService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Budget>> getBudget() {
        return new ResponseEntity<List<Budget>>(this.service.getAllBudgets(), HttpStatus.OK);
    }

    @GetMapping({"/date"})
    public ResponseEntity<Budget> getBudgetByDate(@RequestBody ReadBudgetByDateDTO dateDTO) {
        return new ResponseEntity<Budget>(this.service.getBudgetByDate(dateDTO.date), HttpStatus.CREATED); 
    }

    @PostMapping
    public ResponseEntity<String> createBudget(@RequestBody CreateBudgetDTO budgetDTO) {
        try {
            Budget budget = this.service.createBudget(budgetDTO);
            return new ResponseEntity<>(Double.toString(budget.getTotalCost()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
