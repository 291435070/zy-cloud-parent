package org.zy.cloud.eureka.client.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("eureka/client")
public class CloudEurekaClientController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${server.port}")
	private String port;

	@GetMapping("get")
	@HystrixCommand(fallbackMethod = "hystrixError")
	public Object get(@RequestParam(value = "name") String name) {
		logger.info(port);
		return String.format("[%s] %s : %s", name, port, LocalDateTime.now());
	}

	public String hystrixError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
