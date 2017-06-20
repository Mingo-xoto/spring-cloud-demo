package com.yhq.cloud.config.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
@ConfigurationProperties(prefix = "app")
public class TestConfig {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
