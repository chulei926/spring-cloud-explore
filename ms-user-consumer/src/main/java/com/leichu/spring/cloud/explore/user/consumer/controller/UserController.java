package com.leichu.spring.cloud.explore.user.consumer.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private RestTemplate restTemplate;

	private static final String host = "http://localhost:8001/user-service/";

	@RequestMapping("user/{id}")
	@ResponseBody
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final JsonResult result = restTemplate.getForObject(host + "user/" + id, JsonResult.class, id);
		System.out.println(result);
		return result;
	}


}
