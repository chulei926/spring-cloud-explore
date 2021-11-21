package com.leichu.spring.cloud.explore.user.consumer.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private RestTemplate restTemplate;

//	private static final String host = "http://localhost:8001/user-service/"; // 单节点
	private static final String host = "http://MS-USER-PROVIDER/"; // 这里的 MS-USER-PROVIDER 是服务提供方的 spring.application.name

	@GetMapping("user/{id}")
	@ResponseBody
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final JsonResult<User> result = restTemplate.getForObject(host + "user/" + id, JsonResult.class, id);
		return result;
	}


	@PostMapping("user/create")
	@ResponseBody
	public JsonResult<User> create(@RequestBody User user) {
		final JsonResult<User> result = restTemplate.postForObject(host + "user/create", user, JsonResult.class);
		return result;
	}

}
