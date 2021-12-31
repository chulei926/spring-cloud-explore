package com.leichu.spring.cloud.explore.sb_mybatis_pgsql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Long id;
	private String name;
	private String pwd;
}
