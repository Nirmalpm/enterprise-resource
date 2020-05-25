package com.enterprise.resource.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.enterprise.resource.config.MySqlQueriesProperty;
import com.enterprise.resource.dao.ItemDAO;
import com.enterprise.resource.model.Item;

@Repository
@EnableConfigurationProperties(MySqlQueriesProperty.class)
public class ItemDAOImpl extends BaseDAOImpl implements ItemDAO<Item> {
	@Autowired
	MySqlQueriesProperty mySqlQueriesProperty;

	@Override
	public Item addItem(Item item) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int iAdd = mysqlJdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = null;
				if(item.getItemId() == null) {
					sql = mySqlQueriesProperty.getInsertItem();
				}else {
					sql = mySqlQueriesProperty.getUpdateItem()+ "item_id="+item.getItemId();
				}
				PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pst.setInt(1, item.getEnterpriseId());
				pst.setString(2, item.getItemName());
				pst.setString(3, item.getItemDescription());
				pst.setBigDecimal(4, item.getItemPrice());
				pst.setInt(5, item.getItemQuantity());
				pst.setString(6, item.getItemUnit());
				pst.setString(7, item.getImageName());
				pst.setTimestamp(8, item.getCreatedDate());
				if(item.getItemId() == null || item.getItemId() > 0) {
					pst.setString(9, item.getModifiedUser());
				}else {
					pst.setString(9, item.getCreatedUser());
				}				
				return pst;
			}
		}, keyHolder);
		if(keyHolder != null && keyHolder.getKey() != null) {
			item.setItemId(keyHolder.getKey().intValue());
		}
		
		return item;
	}

	@Override
	public List<Item> getItems(Integer enterpriseId) {
		List<Item> items = mysqlJdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(mySqlQueriesProperty.getSelectItems());
				pst.setInt(1, enterpriseId);
				return pst;
			}
		}, new ResultSetExtractor<List<Item>>() {
			@Override
			public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Item> items = new ArrayList<Item>();
				while (rs.next()) {
					Item item = new Item();
					item.setItemId(rs.getInt("item_id"));
					item.setItemName(rs.getString("item_name"));
					item.setItemDescription(rs.getString("item_desc"));
					item.setItemPrice(rs.getBigDecimal("item_price"));
					item.setItemQuantity(rs.getInt("item_quantity"));
					item.setItemUnit(rs.getString("item_unit"));
					item.setCreatedDate(rs.getTimestamp("created_date"));
					item.setImageName(rs.getString("image_name"));
					items.add(item);
				}
				return items;
			}

		});
		return items;
	}
}
