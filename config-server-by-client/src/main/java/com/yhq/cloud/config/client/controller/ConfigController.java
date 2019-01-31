package com.yhq.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySources;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@Autowired
	private PropertySources propertySources;


	@RequestMapping("")
	public ModelMap config() {
		ModelMap modelMap = new ModelMap();
		modelMap.put("test", environment.getProperty("app.name"));
		modelMap.put("test2",propertySources.get("app.name"));
		modelMap.put("account", environment.getProperty("my.account[0]"));
		modelMap.put("accountList", environment.getProperty("my.account", List.class));
		return modelMap;
	}

}
