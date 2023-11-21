package com.trabalho.um.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabalho.um.DTO.CreatePersistentBudgetDTO;
import com.trabalho.um.domain.entity.BudgetJPA;
import com.trabalho.um.proxy.BudgetProxy;

@Component
public class BudgetRepository implements IBudgetRepository {

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private FanoutExchange fanout;

  @Autowired
  private BudgetProxy proxy;

  @Override
  public void createBudget(CreatePersistentBudgetDTO budget) {
    template.convertAndSend(fanout.getName(), "", budget);
  }

  @Override
  public List<BudgetJPA> getAllBudgets() {
    return proxy.retrieveBudget();
  }

  @Override
  public List<BudgetJPA> getBudgetByDate(LocalDate date) {
    return proxy.retrieveBudgetByDate(date.toString());
  }
  
}
