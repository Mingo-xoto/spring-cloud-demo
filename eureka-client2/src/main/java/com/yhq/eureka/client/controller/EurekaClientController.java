package com.yhq.eureka.client.controller;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@EnableEurekaClient
@RestController
@RequestMapping("/eureka/client/2/")
public class EurekaClientController {
	@RequestMapping("hello")
	public String home() {
		return "Hello world 2";
	}

}
