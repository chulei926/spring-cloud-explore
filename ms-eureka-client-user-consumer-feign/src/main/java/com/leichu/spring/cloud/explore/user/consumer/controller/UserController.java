package com.leichu.spring.cloud.explore.user.consumer.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.user.consumer.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private IUserService iUserService;

	@GetMapping("user/{id}")
	public JsonResult<User> user(@PathVariable("id") Long id) {
		return iUserService.get(id);
	}


}
