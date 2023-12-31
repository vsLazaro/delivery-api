package com.trabalho.um.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trabalho.um.DTO.CreateBudgetDTO;
import com.trabalho.um.DTO.CreatePersistentBudgetDTO;
import com.trabalho.um.DTO.ReadBudgetByDateDTO;
import com.trabalho.um.Service.IBudgetService;
import com.trabalho.um.domain.entity.BudgetJPA;
import com.trabalho.um.proxy.BudgetProxy;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private IBudgetService service;
    private BudgetProxy proxy;

    public BudgetController(IBudgetService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BudgetJPA>> getBudget() {
        return new ResponseEntity<List<BudgetJPA>>(this.service.getAllBudgets(), HttpStatus.OK);
    }

    @GetMapping({"/date"})
    public ResponseEntity<List<BudgetJPA>> getBudgetByDate(@RequestBody ReadBudgetByDateDTO dateDTO) {
        return new ResponseEntity<List<BudgetJPA>>(this.service.getBudgetByDate(dateDTO.date), HttpStatus.CREATED); 
    }

    @PostMapping
    public ResponseEntity<String> createBudget(@RequestBody CreateBudgetDTO budgetDTO) {
        try {
            CreatePersistentBudgetDTO budget = this.service.createBudget(budgetDTO);
            return new ResponseEntity<>(Double.toString(budget.getTotalCost()), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
