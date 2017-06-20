package com.yhq.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhq.cloud.config.client.config.RedisConfig;
import com.yhq.cloud.config.client.config.TestConfig;
import com.yhq.cloud.config.client.config.TestConfig2;

/**
 * @author HuaQi.Yang
 * @date 2017年6月19日
 */
@RestController
@RequestMapping("/config/")
public class ConfigController {

	@Value("${topicExchange.routingKey}")
	private String routingKey;

	@Autowired
	private RedisConfig redisConfig;

	@Autowired
	private TestConfig testConfig;
	@Autowired
	private TestConfig2 testConfig2;

	@RequestMapping("")
	public ModelMap config() {
		ModelMap modelMap = new ModelMap();
		modelMap.put("routingKey", routingKey);
		modelMap.put("redisConfig", redisConfig.getUrl());
		modelMap.put("test", testConfig.getName());
		modelMap.put("test2", testConfig2.getName());
		modelMap.put("account", testConfig2.getAccount());
		return modelMap;
	}
}
