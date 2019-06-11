package org.zy.cloud.config.client.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CloudConfigClientController {

	@Value("${email}")
	private String email;

	@Value("${address}")
	private String address;

	@RequestMapping("get")
	public Object get() throws Exception {
		address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
		return String.format("%s : [%s] [%s]", LocalDateTime.now(), email, address);
	}

}