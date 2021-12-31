package com.leichu.spring.cloud.explore.sb_mybatis_pgsql.controller;

import com.leichu.spring.cloud.explore.sb_mybatis_pgsql.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("update")
	public String update(){
		userService.updateUser();
		return "success";
	}

}
