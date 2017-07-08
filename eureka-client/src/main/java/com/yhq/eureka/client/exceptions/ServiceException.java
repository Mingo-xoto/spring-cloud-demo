package com.yhq.eureka.client.exceptions;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @author HuaQi.Yang
 * @date 2017年7月8日
 */
public class ServiceException extends HystrixBadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7241835472867399970L;

	public ServiceException(String message) {
		super("继承HystrixBadRequestException-->" + message);
	}

}
