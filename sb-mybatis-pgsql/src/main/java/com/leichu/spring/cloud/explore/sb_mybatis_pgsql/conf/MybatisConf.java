package com.leichu.spring.cloud.explore.sb_mybatis_pgsql.conf;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Slf4j
@Configuration
@EnableTransactionManagement
public class MybatisConf implements TransactionManagementConfigurer {

	@Resource
	private DataSource dataSource;

	@Value("${mybatis_mapper_locations}")
	private String mapperPath;

	@Value("${mybatis_config_location}")
	private String mybatisConfigFilePath;

	@Value("${mybatis_type_aliases_package}")
	private String entityPackage;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		log.info("sqlSessionFactory创建成功");
		return sqlSessionFactoryBean;
	}

	@Bean
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		log.info("事务管理器创建成功");
		return transactionManager;
	}
}
