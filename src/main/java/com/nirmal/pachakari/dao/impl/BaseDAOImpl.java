package com.nirmal.pachakari.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nirmal.pachakari.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO {
	
	@Qualifier("mysqlJdbcTemplate")
	@Autowired
	protected JdbcTemplate mysqlJdbcTemplate;
}
