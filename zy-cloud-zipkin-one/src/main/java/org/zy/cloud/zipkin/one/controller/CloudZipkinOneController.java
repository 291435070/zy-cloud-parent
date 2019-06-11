package org.zy.cloud.zipkin.one.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CloudZipkinOneController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/get")
	public Object get() {
		logger.info("服务链路追踪: 1");
		return String.format("[%s] : %s", LocalDateTime.now(), "服务链路追踪: 1");
	}

	@RequestMapping("/zipkin")
	public String zipkin() {
		logger.info("服务链路追踪: 1 -> trace");
		return restTemplate.getForObject("http://127.0.0.1:8011/get", String.class);
	}

	@RequestMapping("/zipkin/map")
	public Object zipkinMap() {
		logger.info("服务链路追踪: 1 -> trace");
		Map<String, Object> param = new HashMap<>();
		param.put("ref_amadeus", "22273BP6");
		param.put("ref_external", "0UwK19q9lrws96bHwOqhiNDQL");
		String result = restTemplate.postForObject("http://127.0.0.1:8011/map", param, String.class);
		return result;
	}

}