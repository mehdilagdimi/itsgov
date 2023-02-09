package com.mehdilagdimi.itsgovhealthcareservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItsgovHealthcareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsgovHealthcareServiceApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
