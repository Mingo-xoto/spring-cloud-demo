package com.yhq.eureka.client;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignContext;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@MySpringBootApplication
public class EurekaClientApplication {

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

	FeignContext context;

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);

	}
}
