package com.leichu.spring.cloud.explore.user.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsZkUserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsZkUserConsumerApplication.class, args);
	}

}
