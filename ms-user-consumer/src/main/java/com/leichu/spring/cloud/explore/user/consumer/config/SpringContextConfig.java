package com.leichu.spring.cloud.explore.user.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringContextConfig {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
