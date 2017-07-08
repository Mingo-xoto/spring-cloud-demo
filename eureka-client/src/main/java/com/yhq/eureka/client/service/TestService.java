package com.yhq.eureka.client.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.yhq.eureka.client.exceptions.ServiceException;
import com.yhq.eureka.client.feign.EurekaService;

/**
 * @author HuaQi.Yang
 * @date 2017年7月8日
 */
@Service
public class TestService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@LoadBalanced
	private RestTemplate loadBalanced;

	@Autowired
	private EurekaService eurekaService;

	public String fallBack(Throwable t) {
		return t + "-断路器：defaultStores-";
	}

	public String fallBack2(Throwable t) {
		return t + "-断路器2：defaultStores-";
	}

	public String fallBack3(Throwable t) {
		return t.getMessage() + "-断路器3：defaultStores-";
	}

	public String fallBack4() {
		return "-断路器4：defaultStores-";
	}

	@HystrixCommand(fallbackMethod = "fallBack2")
	public String home() {
		// ResponseEntity<String> responseEntity =
		// restTemplate.getForEntity("http://projects.spring.io/spring-cloud/",
		// String.class);
		System.out.println("client:" + loadBalanced.hashCode());
		ResponseEntity<String> responseEurekaEntity = loadBalanced.getForEntity("http://eureka-client1/eureka/client/1/hello", String.class);
		int i = 1 / 0;
		return "Hello world 0:" + responseEurekaEntity.getBody();
	}

	@HystrixCommand(fallbackMethod = "fallBack", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
	public String url2() {
		return "url2";
	}

	@HystrixCommand(fallbackMethod = "fallBack3", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
	public String url3() {
		throw new RuntimeException("测试RuntimeException");
	}

	@HystrixCommand(fallbackMethod = "fallBack4", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
	public String hystrixBadRequestException() {
		throw new HystrixBadRequestException("测试HystrixBadRequestException");
	}

	@HystrixCommand(fallbackMethod = "fallBack4", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"))
	public String serviceException() {
		throw new ServiceException("测试serviceException");
	}

}
