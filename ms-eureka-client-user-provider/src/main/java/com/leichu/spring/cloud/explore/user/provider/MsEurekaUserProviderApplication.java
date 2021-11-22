package com.leichu.spring.cloud.explore.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsEurekaUserProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaUserProviderApplication.class, args);
	}

}
