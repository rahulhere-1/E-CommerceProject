package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes().route(
				p -> p.path("/site/orders/**")
						.filters(f -> f.rewritePath("/site/orders/(?<segment>.*)","/${segment}")
								.circuitBreaker(config -> config.setName("ordersCircuitBreaker")))
						.uri("lb://ORDERS"))
				.route(
				p -> p.path("/site/inventory/**")
						.filters(f -> f.rewritePath("/site/inventory/(?<segment>.*)","/${segment}")
								.circuitBreaker(config -> config.setName("inventoryCircuitBreaker")))
						.uri("lb://INVENTORY"))
				.route(
				p -> p.path("/site/product/**")
						.filters(f -> f.rewritePath("/site/product-service/(?<segment>.*)","/${segment}"))
						.uri("lb://PRODUCT"))
						.build();

	}


}
