package org.zy.cloud.feign.server.service.fallback;

import org.springframework.stereotype.Component;
import org.zy.cloud.feign.server.service.HelloSchedualService;

@Component
public class HelloSchedualServiceHystrix implements HelloSchedualService {

	@Override
	public String helloFeign(String name) {
		return String.format("{%s} : %s", name, "sorry, feign error");
	}

}
