package com.yhq.cloud.config.client.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
@ConfigurationProperties(prefix = "my")
public class TestConfig {

	@Value("${app.name}")
	private String name;

	private List<String> account;

	public String getName() {
		return name;
	}

	public List<String> getAccount() {
		return account;
	}

	public void setAccount(List<String> account) {
		this.account = account;
	}

}
