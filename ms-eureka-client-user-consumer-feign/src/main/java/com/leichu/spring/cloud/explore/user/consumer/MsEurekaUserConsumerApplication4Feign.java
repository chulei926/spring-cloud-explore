package com.leichu.spring.cloud.explore.user.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsEurekaUserConsumerApplication4Feign {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaUserConsumerApplication4Feign.class, args);
	}

}
