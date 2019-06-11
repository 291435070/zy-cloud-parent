package org.zy.cloud.feign.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zy.cloud.feign.server.service.HelloSchedualService;

@RestController
@RequestMapping("feign")
public class HelloController {

	@Autowired
	private HelloSchedualService helloSchedualService;

	@GetMapping("hello")
	public Object hello(@RequestParam String name) {
		return helloSchedualService.helloFeign(name);
	}

}