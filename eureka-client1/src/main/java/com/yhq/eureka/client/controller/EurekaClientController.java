package com.yhq.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/eureka/client/1/")
public class EurekaClientController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@LoadBalanced
	private RestTemplate loadBalanced;

	@RequestMapping("hello")
	public String home() {
		// ResponseEntity<String> responseEntity =
		// restTemplate.getForEntity("http://projects.spring.io/spring-cloud/",
		// String.class);
		System.out.println("client1:"+loadBalanced.hashCode());
		ResponseEntity<String> responseEurekaEntity = loadBalanced
				.getForEntity("http://eureka-client/eureka/client/url2", String.class);
		return "Hello world 1:"+ responseEurekaEntity.getBody();
	}

}
