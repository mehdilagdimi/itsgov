package com.mehdilagdimi.itsgovfinanceservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ItsgovFinanceServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ItsgovFinanceServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@Qualifier("auth-service")
	public String serviceUrl(){
		return "http://AUTH-SERVICE";
	}

}
