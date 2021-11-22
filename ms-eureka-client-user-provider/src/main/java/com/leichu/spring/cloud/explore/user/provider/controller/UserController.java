package com.leichu.spring.cloud.explore.user.provider.controller;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

	@Resource
	private UserService userService;

	@Value("${server.port}")
	private Integer port;

	@RequestMapping("user/{id}")
	@ResponseBody
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final User user = userService.get(id);
		final JsonResult<User> result = JsonResult.getSuccessResult(user);
		result.setMsg(port.toString());
		return result;
	}

	@PostMapping("user/create")
	@ResponseBody
	public JsonResult<User> create(@RequestBody User user) {
		final Long id = userService.save(user);
		final User user1 = userService.get(id);
		final JsonResult<User> result = JsonResult.getSuccessResult(user1);
		result.setMsg(port.toString());
		return result;
	}

}
