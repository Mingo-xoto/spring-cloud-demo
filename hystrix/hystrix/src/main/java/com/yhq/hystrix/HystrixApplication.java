package com.yhq.hystrix;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class HystrixApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(HystrixApplication.class).web(true).run(args);
	}
}
