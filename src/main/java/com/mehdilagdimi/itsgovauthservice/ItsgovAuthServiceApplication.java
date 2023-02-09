package com.mehdilagdimi.itsgovauthservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ItsgovAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsgovAuthServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    @Qualifier("entry-point-url")
    public String getEntryPointUrl(){
        return "http://localhost:8090";
    }

}
