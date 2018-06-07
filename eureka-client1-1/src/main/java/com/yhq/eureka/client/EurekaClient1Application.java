package com.yhq.eureka.client;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MySpringBootApplication
public class EurekaClient1Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClient1Application.class).web(true).run(args);

	}
}
