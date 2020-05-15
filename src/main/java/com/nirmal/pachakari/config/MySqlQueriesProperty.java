package com.nirmal.pachakari.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@PropertySource("classpath:mysql.properties")
@ConfigurationProperties(prefix="sql")
@Data
public class MySqlQueriesProperty {
	private String insertItem;
	private String insertOrder;
	private String insertOrderItems;
	private String selectItems;
}
