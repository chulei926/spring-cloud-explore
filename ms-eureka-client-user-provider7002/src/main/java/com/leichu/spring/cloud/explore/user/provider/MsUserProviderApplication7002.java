package com.leichu.spring.cloud.explore.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsUserProviderApplication7002 {

	public static void main(String[] args) {
		SpringApplication.run(MsUserProviderApplication7002.class, args);
	}

}
