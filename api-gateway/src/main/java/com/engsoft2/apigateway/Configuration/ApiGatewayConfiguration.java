package com.engsoft2.apigateway.Configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
    return builder.routes()
      .route(p -> p.path("/cities").uri("lb://delivery-api"))
      .route(p ->
        p.path("/cities/cep/**").uri("lb://delivery-api")
      ).route(p ->
        p.path("/budgets").uri("lb://delivery-api")
      ).route(p ->
        p.path("/budgets/date/**").uri("lb://delivery-api")
      )
      .build();
  }
}
