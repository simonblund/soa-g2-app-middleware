package com.g2.examinationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.g2.examinationservice.infrastructure.rest")
@SpringBootApplication
public class AppMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMiddlewareApplication.class, args);
	}

}
