package com.leichu.spring.cloud.explore.sb_mybatis_pgsql.service;

import com.leichu.spring.cloud.explore.sb_mybatis_pgsql.mapper.UserMapper;
import com.leichu.spring.cloud.explore.sb_mybatis_pgsql.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private PlatformTransactionManager transactionManager;

	public void updateUser() {
		log.warn("开始更新 {} {}", userMapper, transactionManager);

		for (long i = 1; i <= 3; i++) {
			User user = User.builder().id(i).name(String.format("n%d%d", i, i)).pwd(String.format("p%d%d", i, i)).build();
			TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
			userMapper.update(user);
			log.info("user{}已更新", i);
			if (i != 2) {
				transactionManager.commit(transactionStatus);
				log.info("user{}已提交", i);
			} else {
				transactionManager.rollback(transactionStatus);
				log.info("user{}已回滚", i);
			}
		}


	}
}
