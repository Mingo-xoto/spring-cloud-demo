package com.yhq.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@EnableEurekaClient
@RestController
@RequestMapping("/eureka/client/")
public class EurekaClientController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("hello")
	public String home() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-client1/eureka/client/1/hello",
				String.class);
		System.out.println(responseEntity);
		return "Hello world 0:" + responseEntity.getBody();
	}

}
