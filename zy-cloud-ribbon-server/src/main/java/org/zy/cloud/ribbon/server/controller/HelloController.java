package org.zy.cloud.ribbon.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zy.cloud.ribbon.server.service.HelloServer;

@RestController
@RequestMapping("ribbon")
public class HelloController {

	@Autowired
	private HelloServer helloServer;

	@GetMapping("hello")
	public Object hello(@RequestParam String name) {
		return helloServer.hello(name);
	}

}