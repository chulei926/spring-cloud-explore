package com.leichu.spring.cloud.explore.user.provider.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("user/{id}")
	@ResponseBody
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final User user = userService.get(id);
		return JsonResult.getSuccessResult(user);
	}

}
