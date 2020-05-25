package com.enterprise.resource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration

public class DBConfigurations {
	@Bean(name="mysqlDb")	
	@ConfigurationProperties(prefix="spring.mysql.datasource")
	public DataSource mySqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlJdbcTemplate")
	public JdbcTemplate mySqlTemplate(@Qualifier("mysqlDb") DataSource mySqlDataSource) {
		return new JdbcTemplate(mySqlDataSource);
	}
	
}
