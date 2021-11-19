package com.leichu.spring.cloud.explore.common.service;

import com.leichu.spring.cloud.explore.common.model.User;

public interface UserService {

	Long save(User user);

	User get(Long id);

	void update(User user);

	void del(Long id);

}
