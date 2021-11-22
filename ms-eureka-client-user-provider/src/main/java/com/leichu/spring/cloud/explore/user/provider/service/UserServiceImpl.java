package com.leichu.spring.cloud.explore.user.provider.service;

import com.leichu.spring.cloud.explore.common.model.User;
import com.leichu.spring.cloud.explore.common.service.UserService;
import com.leichu.spring.cloud.explore.user.provider.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public Long save(User user) {
		userMapper.insert(user);
		return user.getId();
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
