package com.leichu.spring.cloud.explore.user;

import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MsUserProviderApplicationTests {

	@Resource
	UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void t1(){
		System.out.println("hello " + userMapper);
		final User user = userMapper.find(1L);
		System.out.println(user);
	}

}
