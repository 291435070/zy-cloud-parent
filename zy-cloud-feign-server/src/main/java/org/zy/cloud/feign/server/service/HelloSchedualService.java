package org.zy.cloud.feign.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zy.cloud.feign.server.service.fallback.HelloSchedualServiceHystrix;

@FeignClient(value = "EUREKA-CLIENT", fallback = HelloSchedualServiceHystrix.class)
public interface HelloSchedualService {

	@RequestMapping(value = "eureka/client/get", method = RequestMethod.GET)
	String helloFeign(@RequestParam(value = "name") String name);

}