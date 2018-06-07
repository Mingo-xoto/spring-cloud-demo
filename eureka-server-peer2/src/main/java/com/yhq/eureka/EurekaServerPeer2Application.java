package com.yhq.eureka;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@EnableEurekaServer
@MySpringBootApplication
public class EurekaServerPeer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerPeer2Application.class, args);
	}
}
