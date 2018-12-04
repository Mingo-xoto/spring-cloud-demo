package com.yhq.cloud.config.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author HuaQi.Yang
 * @date 2017年6月20日
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig{

	private List<String> url;

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters() {
//		// 1、需要先定义一个 convert 转换消息的对象;
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//		//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//		//2-1 处理中文乱码问题
//		List<MediaType> fastMediaTypes = new ArrayList<>();
//		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		fastConverter.setSupportedMediaTypes(fastMediaTypes);
//
//		//3、在convert中添加配置信息.
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//
//		HttpMessageConverter<?> converter = fastConverter;
//		return new HttpMessageConverters(converter);
//	}

}
