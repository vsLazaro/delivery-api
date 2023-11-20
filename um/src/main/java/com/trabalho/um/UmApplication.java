package com.trabalho.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UmApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmApplication.class, args);
	}
}
