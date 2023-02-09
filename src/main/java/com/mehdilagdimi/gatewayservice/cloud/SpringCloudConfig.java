package com.mehdilagdimi.gatewayservice.cloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "employeeModule" ,
                        r -> r.path("/employee/**").uri("lb://EMPLOYEE-SERVICE")
                )
                .route("authModule",
                        r -> r.path("/auth/**").uri("lb://AUTH-SERVICE")
                )
                .route("financeModule",
                        r -> r.path("/finance/**").uri("lb://FINANCE-SERVICE")
                )
                .route("healthcareModule",
                        r -> r.path("/healthcare/**").uri("lb://HEALTHCARE-SERVICE")
                )
                .build();
    }

}