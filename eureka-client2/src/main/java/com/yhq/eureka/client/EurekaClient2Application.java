package com.yhq.eureka.client;

import com.yhq.config.MySpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MySpringBootApplication
public class EurekaClient2Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClient2Application.class).web(true).run(args);

	}
}
