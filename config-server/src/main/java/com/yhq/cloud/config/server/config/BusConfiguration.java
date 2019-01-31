package com.yhq.cloud.config.server.config;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//RemoteApplicationEventScan默认会以使用了该注解的类所在的包路径作为扫描路径，这里是BusConfiguration的包路径com.yhq.config
@RemoteApplicationEventScan
public class BusConfiguration {
}
