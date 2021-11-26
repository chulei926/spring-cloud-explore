package com.leichu.spring.cloud.explore.user.consumer;

import com.leichu.spring.cloud.explore.user.rule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MS-USER-PROVIDER", configuration = CustomRule.class)
public class MsEurekaUserConsumerApplication4Ribbon {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaUserConsumerApplication4Ribbon.class, args);
	}

}
