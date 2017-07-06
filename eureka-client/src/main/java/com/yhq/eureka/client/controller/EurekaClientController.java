package com.yhq.eureka.client.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yhq.eureka.client.feign.EurekaService;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/eureka/client/")
public class EurekaClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@LoadBalanced
	private RestTemplate loadBalanced;

	@Autowired
	private EurekaService eurekaService;

	@RequestMapping("hello")
	public String home() {
		// ResponseEntity<String> responseEntity =
		// restTemplate.getForEntity("http://projects.spring.io/spring-cloud/",
		// String.class);
		System.out.println("client:" + loadBalanced.hashCode());
		ResponseEntity<String> responseEurekaEntity = loadBalanced
				.getForEntity("http://eureka-client1/eureka/client/1/hello", String.class);

		return "Hello world 0:" + responseEurekaEntity.getBody();
	}

	@RequestMapping("url2")
	@HystrixCommand(fallbackMethod = "fallBack", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
	public String url2() {
		System.out.println("client:" + loadBalanced.hashCode());
		while (loadBalanced.hashCode() != 1) {
		}
		return "url2";
	}

	public String fallBack() {
		return "-断路器：defaultStores-";
	}
}
