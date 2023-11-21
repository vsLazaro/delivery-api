package com.trabalho.um.proxy;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trabalho.um.domain.entity.BudgetJPA;

@FeignClient(name = "register-budget")
public interface BudgetProxy {
    @GetMapping("/budgets")
    public List<BudgetJPA> retrieveBudget();

    @GetMapping("/budgets/date/{date}")
    public List<BudgetJPA> retrieveBudgetByDate(@PathVariable String date);
}
