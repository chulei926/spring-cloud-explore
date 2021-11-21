package com.leichu.spring.cloud.explore.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaServer7000 {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaServer7000.class, args);
	}

}
