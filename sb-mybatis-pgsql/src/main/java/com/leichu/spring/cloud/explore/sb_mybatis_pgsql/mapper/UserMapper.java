package com.leichu.spring.cloud.explore.sb_mybatis_pgsql.mapper;

import com.leichu.spring.cloud.explore.sb_mybatis_pgsql.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	void update(User user);

}
