package com.yhq.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication(scanBasePackages = "com.yhq.config")
public @interface MySpringBootApplication {
}
