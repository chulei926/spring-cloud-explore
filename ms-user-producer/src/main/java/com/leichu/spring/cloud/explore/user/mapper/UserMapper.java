package com.leichu.spring.cloud.explore.user.mapper;

import com.leichu.spring.cloud.explore.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


	Long insert(User user);

	@Select("SELECT * FROM tb_user WHERE id = #{id}")
	User find(@Param("id") Long id);

	void update(User user);

	void del(Long id);
}
