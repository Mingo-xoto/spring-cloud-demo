package com.yhq.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerPeer4Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerPeer4Application.class, args);
	}
}
