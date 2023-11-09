package com.trabalho.um.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trabalho.um.domain.Repository.Budget;
import com.trabalho.um.domain.Service.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private BudgetService service;

    public BudgetController(BudgetService service) {
      this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable int id) {
        Budget budget = service.getBudgetById(id);
        if (budget != null) {
            return new ResponseEntity<>(budget, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createBudget(@RequestBody Budget budget) {
        return new ResponseEntity<>("Orçamento criado com sucesso.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBudget(@PathVariable int id, @RequestBody Budget budget) {
        return new ResponseEntity<>("Orçamento atualizado com sucesso.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable int id) {
        return new ResponseEntity<>("Orçamento excluído com sucesso.", HttpStatus.OK);
    }
}
