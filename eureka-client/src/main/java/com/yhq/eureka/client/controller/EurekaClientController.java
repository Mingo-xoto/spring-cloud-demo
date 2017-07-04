package com.yhq.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://projects.spring.io/spring-cloud/",
				String.class);
		ResponseEntity<String> responseEurekaEntity = loadBalanced.getForEntity("http://eureka-client1/eureka/client/1/hello",
				String.class);
		System.out.println(responseEurekaEntity);
		System.out.println(eurekaService.hello());
		return "Hello world 0:" + responseEurekaEntity.getBody();
	}

}
