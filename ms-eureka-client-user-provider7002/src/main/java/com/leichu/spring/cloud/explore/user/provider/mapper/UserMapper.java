package com.leichu.spring.cloud.explore.user.provider.mapper;

import com.leichu.spring.cloud.explore.common.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO tb_user(NAME, AGE) VALUES(#{name}, #{age})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void insert(User user);

	@Select("SELECT * FROM tb_user WHERE id = #{id}")
	User find(@Param("id") Long id);

	void update(User user);

	void del(Long id);
}
