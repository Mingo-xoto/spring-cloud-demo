package com.yhq.cloud.config.client.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig{

	private List<String> url;

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

}
