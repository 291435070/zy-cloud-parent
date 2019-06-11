package org.zy.cloud.ribbon.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix // 断路器注解
public class CloudRibbonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudRibbonServerApplication.class, args);
	}
}