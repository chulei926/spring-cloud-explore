package com.leichu.spring.cloud.explore.user.provider.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("user/{id}")
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final User user = userService.get(id);
		System.out.println(user);
		return JsonResult.getSuccessResult(user);
	}

	@PostMapping("user/create")
	public JsonResult<User> create(@RequestBody User user) {
		final Long id = userService.save(user);
		final User user1 = userService.get(id);
		return JsonResult.getSuccessResult(user1);
	}

}
