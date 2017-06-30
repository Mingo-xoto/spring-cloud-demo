package com.yhq.eureka.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@EnableEurekaClient
@RestController
@RequestMapping("/eureka/client/3/")
public class EurekaClientController {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	public String serviceUrl() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("eureka-client2", false);
		return instance.getSecureHealthCheckUrl();
	}

	public List<ServiceInstance> serviceUrls() {
		List<ServiceInstance> list = discoveryClient.getInstances("eureka-client2");
		for (ServiceInstance serviceInstance : list) {
			System.out.println(serviceInstance.getUri());
		}
		return list;
	}

	public void getServices() {
		List<String> serviceIds = discoveryClient.getServices();
		for (String serviceId : serviceIds) {
			System.out.println(serviceId);
		}
	}

	@RequestMapping("hello")
	public String home() {
		getServices();
		return "Hello world 3\n" + serviceUrls();
	}

}
