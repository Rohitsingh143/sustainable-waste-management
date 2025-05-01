package com.waste.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@EnableDiscoveryClient

public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		System.out.println("Gateway is running");
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("user-service", r -> r.path("/api/users/**").uri("lb://user-service"))
//				.route("pickup-service", r -> r.path("/api/pickups/**").uri("lb://pickup-service"))
//				.route("analytics-service", r -> r.path("/api/analytics/**").uri("lb://analytics-service"))
//				.route("notification-service", r -> r.path("/api/notifications/**").uri("lb://notification-service"))
//				.build();
//	}

}
