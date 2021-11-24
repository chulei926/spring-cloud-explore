package com.leichu.spring.cloud.explore.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsulUserProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsulUserProviderApplication.class, args);
	}

}
