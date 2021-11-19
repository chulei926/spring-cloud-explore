package com.leichu.spring.cloud.explore.user.service;

import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import com.leichu.spring.cloud.explore.user.mapper.UserMapper;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public Long save(User user) {
		return userMapper.insert(user);
	}

	@Override
	public User get(Long id) {
		return userMapper.find(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void del(Long id) {
		userMapper.del(id);
	}

}
