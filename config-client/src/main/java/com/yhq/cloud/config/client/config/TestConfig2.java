package com.yhq.cloud.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
public class TestConfig2 {

	@Value("${app.name}")
	private String name;

	public String getName() {
		return name;
	}


}
