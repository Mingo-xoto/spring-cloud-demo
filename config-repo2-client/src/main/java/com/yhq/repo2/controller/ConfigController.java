package com.yhq.repo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaQi.Yang
 * @date 2017年6月19日
 */
@RestController
@RequestMapping("/config/")
public class ConfigController {

	@Value("${test.rpc}")
	private String rpc;

	@Value("${topicExchange.routingKey}")
	private String routingKey;
	
	@RequestMapping("")
	public ModelMap config() {
		ModelMap modelMap = new ModelMap();
		modelMap.put("routingKey", routingKey);
		modelMap.put("rpc", rpc);
		return modelMap;
	}
}