package com.yhq.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/eureka/client/1/")
public class EurekaClientController {
	@RequestMapping("hello")
	public String home() {
		return "Hello world 1-1";
	}

}
