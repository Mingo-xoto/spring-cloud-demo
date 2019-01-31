package com.yhq.cloud.config.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomRemoteEventListener implements ApplicationListener<MyCustomRemoteEvent> {

    private Logger logger = LoggerFactory.getLogger(MyCustomRemoteEventListener.class);

    @Override
    public void onApplicationEvent(MyCustomRemoteEvent event) {
        logger.info("Received MyCustomRemoteEvent - message: " + event);
    }


}
