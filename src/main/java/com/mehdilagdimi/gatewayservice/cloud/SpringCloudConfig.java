package com.mehdilagdimi.gatewayservice.cloud;

import com.mehdilagdimi.gatewayservice.security.GatewayAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringCloudConfig {
  private  final  GatewayFilter GatewayAuthFilter;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "employeeModule" ,
                        r -> r.path("/employee/**")
                                .filters(gatewayFilterSpec -> gatewayFilterSpec.filter(GatewayAuthFilter))
                                .uri("lb://EMPLOYEE-SERVICE")
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