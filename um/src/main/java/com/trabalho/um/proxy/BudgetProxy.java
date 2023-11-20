package com.trabalho.um.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trabalho.um.domain.entity.BudgetJPA;

@FeignClient(name = "budgets")
public interface BudgetProxy {
    @GetMapping("/budgets/")
    public List<BudgetJPA> retrieveBudget(List<BudgetJPA> budget);
}
