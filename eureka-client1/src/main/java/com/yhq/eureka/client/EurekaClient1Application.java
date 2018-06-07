package com.yhq.eureka.client;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@MySpringBootApplication
public class EurekaClient1Application {
	// rest 请求对象，具有负载均衡的能力
	@Bean
	@LoadBalanced
	RestTemplate loadBalanced() {
		return new RestTemplate();
	}

	@Bean
	@Primary
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClient1Application.class).web(true).run(args);

	}
}
