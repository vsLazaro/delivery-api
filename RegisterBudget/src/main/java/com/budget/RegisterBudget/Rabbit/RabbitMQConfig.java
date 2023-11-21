package com.budget.RegisterBudget.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  public static final String fanoutExchangeName = "create.budget";
  public static final String queueName = "create.budget";

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(fanoutExchangeName);
  }

  @Bean
  public Queue queue() {
    return new Queue(queueName);
  }

  @Bean
  public Binding binding(Queue q, FanoutExchange f) {
    return BindingBuilder.bind(q).to(f);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter messageConverter) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
    rabbitTemplate.setMessageConverter(messageConverter);
    return rabbitTemplate;
  }
}