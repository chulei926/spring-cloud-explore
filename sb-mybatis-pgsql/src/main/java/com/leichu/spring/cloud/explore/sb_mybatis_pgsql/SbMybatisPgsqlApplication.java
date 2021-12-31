package com.leichu.spring.cloud.explore.sb_mybatis_pgsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SbMybatisPgsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMybatisPgsqlApplication.class, args);
	}

}
