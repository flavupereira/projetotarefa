package com.flavio.microservice.tarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@FeignClient
public class TarefaApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTamplate() {
		return new RestTemplate();
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}

}
