package com.nirmal.pachakari.dao.impl;

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

import com.nirmal.pachakari.config.MySqlQueriesProperty;
import com.nirmal.pachakari.dao.ItemDAO;
import com.nirmal.pachakari.model.Item;

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
				PreparedStatement pst = con.prepareStatement(mySqlQueriesProperty.getInsertItem(),
						Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, item.getItemName());
				pst.setString(2, item.getItemDescription());
				pst.setDouble(3, item.getItemPrice());
				pst.setInt(4, item.getItemQuantity());
				pst.setString(5, item.getItemUnit());
				pst.setString(6, item.getImageName());
				pst.setTimestamp(7, item.getCreatedDate());
				return pst;
			}
		}, keyHolder);
		item.setItemId(keyHolder.getKey().intValue());
		return item;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = mysqlJdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(mySqlQueriesProperty.getSelectItems());
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
					item.setItemPrice(rs.getDouble("item_price"));
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
