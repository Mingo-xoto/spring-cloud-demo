package com.yhq.eureka.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HuaQi.Yang
 * @date 2017年7月3日
 */
@FeignClient("eureka-client1")
public interface EurekaService {
	String CLIETN1_ROOT_URL = "/eureka/client/1/";

	@RequestMapping(CLIETN1_ROOT_URL + "hello")
	public String hello();

}
