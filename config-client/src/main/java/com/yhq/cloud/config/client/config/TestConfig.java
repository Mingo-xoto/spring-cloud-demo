package com.yhq.cloud.config.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
@ConfigurationProperties(prefix = "my")
public class TestConfig {

	private String name;

	private List<String> account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAccount() {
		return account;
	}

	public void setAccount(List<String> account) {
		this.account = account;
	}

}
