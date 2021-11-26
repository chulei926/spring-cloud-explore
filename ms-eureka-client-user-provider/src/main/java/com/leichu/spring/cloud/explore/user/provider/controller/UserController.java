package com.leichu.spring.cloud.explore.user.provider.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class UserController {

	@Resource
	private UserService userService;

	@Value("${server.port}")
	private Integer port;

	@Resource
	private DiscoveryClient discoveryClient;

	@RequestMapping("user/{id}")
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final User user = userService.get(id);
		final JsonResult<User> result = JsonResult.getSuccessResult(user);
		result.setMsg(port.toString());
		// 模拟客户端超时
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping("user/create")
	public JsonResult<User> create(@RequestBody User user) {
		final Long id = userService.save(user);
		final User user1 = userService.get(id);
		final JsonResult<User> result = JsonResult.getSuccessResult(user1);
		result.setMsg(port.toString());
		return result;
	}

	@GetMapping("discovery")
	public Object discovery() {
		final List<String> services = discoveryClient.getServices();
		for (String service : services) {
			System.out.println(service);
		}
		final List<ServiceInstance> instances = discoveryClient.getInstances("MS-USER-PROVIDER");
		return instances;
	}

}
