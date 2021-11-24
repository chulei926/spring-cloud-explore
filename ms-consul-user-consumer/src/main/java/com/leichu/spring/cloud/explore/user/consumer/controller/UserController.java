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

	private static final String host = "http://ms-user-provider/";

	@GetMapping("user/{id}")
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final JsonResult<User> result = restTemplate.getForObject(host + "user/" + id, JsonResult.class, id);
		return result;
	}


	@PostMapping("user/create")
	public JsonResult<User> create(@RequestBody User user) {
		final JsonResult<User> result = restTemplate.postForObject(host + "user/create", user, JsonResult.class);
		return result;
	}

}
