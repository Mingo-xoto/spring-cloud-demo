package com.yhq.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhq.eureka.client.service.TestService;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/eureka/client/")
public class EurekaClientController {

	private static Logger logger = LoggerFactory.getLogger(EurekaClientController.class);
	@Autowired
	private TestService testService;

	private static int count = 0;

	@Value("${test.value1}")
	private String value;

	@RequestMapping("hello")
	public String home() {
		System.out.println("value:"+value);
//		logger.debug("debug hello");
//		logger.error("error hello");
//		logger.info("info hello");
//		logger.warn("warn hello");
//		logger.trace("trace hello");
		System.out.println("请求次数:" + count++);
		return testService.home();
	}

	@RequestMapping("url2")
	public String url2() {
		return testService.url2();
	}

	@RequestMapping("url3")
	public String url3() {
		String result = "";
		try {
			result = testService.url3();
		} catch (Exception e) {
			System.out.println("异常：" + e.getMessage());
		}
		return result;
	}

	@RequestMapping("hystrixBadRequestException")
	public String hystrixBadRequestException() {
		String result = "";
		try {
			result = testService.hystrixBadRequestException();
		} catch (Exception e) {
			result = "异常：" + e.getMessage();
		}
		return result;
	}

	@RequestMapping("serviceException")
	public String serviceException() {
		String result = "";
		try {
			result = testService.serviceException();
		} catch (Exception e) {
			result = "异常：" + e.getMessage();
		}
		return result;
	}

}
