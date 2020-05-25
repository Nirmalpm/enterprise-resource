package com.enterprise.resource.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.enterprise.resource.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO {
	
	@Qualifier("mysqlJdbcTemplate")
	@Autowired
	protected JdbcTemplate mysqlJdbcTemplate;
}
