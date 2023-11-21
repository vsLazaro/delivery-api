package com.budget.RegisterBudget.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.budget.RegisterBudget.DTO.CreateBudgetDTO;
import com.budget.RegisterBudget.Service.IBudgetService;

@Component
public class BudgetConsumer {
  public static final String queueName = "create.budget";
  private IBudgetService service;

  public BudgetConsumer(IBudgetService service) {
    this.service = service;
  }

  @RabbitListener(queues = queueName)
  public void receive(CreateBudgetDTO dto) {
    try {
      service.createBudget(dto); 
    } catch(Exception e) {
      System.err.println("erro: " + e);
    }
    
  }
}
