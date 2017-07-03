package com.yhq.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	private EurekaService eurekaService;

	@RequestMapping("hello")
	public String home() {
		System.out.println(eurekaService.hello());
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-client1/eureka/client/1/hello",
				String.class);
		System.out.println(responseEntity);
		return "Hello world 0:" + responseEntity.getBody();
	}

}
