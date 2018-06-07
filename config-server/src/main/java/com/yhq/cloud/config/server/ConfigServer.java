package com.yhq.cloud.config.server;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author HuaQi.Yang
 * @date 2017年6月19日
 */
@MySpringBootApplication
@EnableConfigServer
public class ConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
	}
}
