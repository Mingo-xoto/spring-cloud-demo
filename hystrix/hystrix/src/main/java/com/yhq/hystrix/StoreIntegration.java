package com.yhq.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author HuaQi.Yang
 * @date 2017年7月4日
 */
@Component
@Controller
public class StoreIntegration {

	@HystrixCommand(fallbackMethod = "defaultStores")
	public Object getStores(Map<String, Object> parameters) {
		return parameters;
	}

	public Object defaultStores(Map<String, Object> parameters) {
		return parameters;
	}
}
