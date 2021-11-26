package com.leichu.spring.cloud.explore.user.consumer.service;

import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "MS-USER-PROVIDER")
public interface IUserService {

	@RequestMapping("user/{id}")
	JsonResult<User> get(@PathVariable("id") Long id);
}
