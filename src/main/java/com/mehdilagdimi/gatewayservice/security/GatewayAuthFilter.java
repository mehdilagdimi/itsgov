package com.mehdilagdimi.gatewayservice.security;

import com.mehdilagdimi.gatewayservice.model.UserDTO;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class GatewayAuthFilter extends AbstractGatewayFilterFactory {

    private final WebClient.Builder builder;

    public GatewayAuthFilter(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return ((exchange, chain) -> {
            String[] authHeaderSplitted;
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Not authenticated");
            } else {
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                authHeaderSplitted = authHeader.split("");

                if (authHeaderSplitted.length != 2 || !"Bearer".equals(authHeaderSplitted[0])) {
                    throw new RuntimeException("Incorrect Auth Header");
                }
            }

            return builder
                    .build()
                    .get()
                    .uri("http://localhost:8090/auth?token=" + authHeaderSplitted[1])
                    .retrieve().bodyToMono(UserDTO.class)
                    .map(userDTO -> {
                        exchange
                                .getRequest()
                                .mutate()
                                .header("x-auth-user", String.valueOf(userDTO));
                        return exchange;
                    })
                    .flatMap(chain::filter);
        });
    }

}
