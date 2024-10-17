package com.example.demo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("candidats", r->r.path("/candidats/**")
						.uri("http://localhost:8082/"))//candidat:8082
				.route("jobs", r->r.path("/jobs/**")
						.uri("http://localhost:8085/"))//job:8085

				.build();
	}
}
