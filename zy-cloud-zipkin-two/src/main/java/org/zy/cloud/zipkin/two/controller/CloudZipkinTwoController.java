package org.zy.cloud.zipkin.two.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CloudZipkinTwoController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/get")
	public Object get() {
		logger.info("服务链路追踪: 2");
		return String.format("[%s] : %s", LocalDateTime.now(), "服务链路追踪: 2");
	}

	@RequestMapping("/zipkin")
	public String zipkin() {
		logger.info("服务链路追踪: 2 -> trace");
		return restTemplate.getForObject("http://127.0.0.1:8010/get", String.class);
	}

	@RequestMapping("/map")
	public Object map(@RequestBody Map<String, Object> param) {
		logger.info("Param : {}", param);
		param.put("code", 200);
		param.put("msg", "服务追踪SUCCESS");
		param.put("date", LocalDateTime.now());
		return param;
	}

}