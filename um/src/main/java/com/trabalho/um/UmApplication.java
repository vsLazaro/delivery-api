package com.trabalho.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.trabalho.um"})
public class UmApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmApplication.class, args);
	}
}
