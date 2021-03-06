package com.leichu.spring.cloud.explore.user.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsEurekaUserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaUserConsumerApplication.class, args);
	}

}
