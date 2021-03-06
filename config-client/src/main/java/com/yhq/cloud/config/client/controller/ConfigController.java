package com.yhq.cloud.config.client.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhq.cloud.config.client.config.RedisConfig;
import com.yhq.cloud.config.client.config.TestConfig;
import com.yhq.cloud.config.client.config.TestConfig2;
import com.yhq.cloud.config.client.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author HuaQi.Yang
 * @date 2017年6月19日
 */
@RestController
@RequestMapping("/config/")
public class ConfigController {

	@Autowired
	private Environment environment;

	@Value("${topicExchange.routingKey}")
	private String routingKey;

	@Value("${test.name}")
	private String name;

	@Autowired
	private RedisConfig redisConfig;

	@Autowired
	private TestConfig testConfig;
	@Autowired
	private TestConfig2 testConfig2;

	@RequestMapping("")
	public ModelMap config() {
		ModelMap modelMap = new ModelMap();
		modelMap.put("name", name);
		modelMap.put("routingKey", routingKey);
		modelMap.put("redisConfig", redisConfig.getUrl());
		modelMap.put("test", environment.getProperty("app.name"));
		modelMap.put("test-1", testConfig.getName());
		modelMap.put("test2", testConfig2.getName());
		modelMap.put("account", environment.getProperty("my.account[0]"));
		modelMap.put("accountList", environment.getProperty("my.account", List.class));
		return modelMap;
	}


	@RequestMapping(value = "test/vo")
	public TestVo getTestVo(int year, int month, int day, int hour, int minute, int second, @JsonFormat(pattern = "HH:mm",timezone="GMT+8")Date date)  {
		System.out.println(date);
		return TestVo.getInstance(year, month, day,hour,minute,second);
	}
}
