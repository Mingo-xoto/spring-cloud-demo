package com.yhq.cloud.config.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;
import org.springframework.web.context.support.StandardServletEnvironment;

@Configuration
public class Config {
    @Bean
    public Environment environment(){
        return new StandardServletEnvironment();
    }

    @Bean
    public PropertySources propertySources(){
        return new MutablePropertySources();
    }
}
