package org.zy.cloud.ribbon.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloServer {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "restError") // 断路器注解指定方法
	public String hello(String name) {
		return restTemplate.getForObject("http://EUREKA-CLIENT/eureka/client/get?name=" + name, String.class);
	}

	// 断路器方法
	public String restError(String name) {
		return String.format("{%s} : %s", name, "sorry, ribbon error");
	}

}