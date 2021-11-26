package com.leichu.spring.cloud.explore.user.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRule {

	@Bean
	public IRule myRule() {
		return new RandomRule();
	}

}
