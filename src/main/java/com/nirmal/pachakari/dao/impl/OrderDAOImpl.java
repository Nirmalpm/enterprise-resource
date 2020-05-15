package com.nirmal.pachakari.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nirmal.pachakari.config.MySqlQueriesProperty;
import com.nirmal.pachakari.dao.OrderDAO;
import com.nirmal.pachakari.errors.ItemException;
import com.nirmal.pachakari.model.Order;
import com.nirmal.pachakari.model.PurchaseItem;

@Repository
public class OrderDAOImpl extends BaseDAOImpl implements OrderDAO<Order> {
	
	@Autowired
	MySqlQueriesProperty mySqlQueriesProperty; 
	
	@Override
	@Transactional
	public boolean addOrder(Order order) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		mysqlJdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(mySqlQueriesProperty.getInsertOrder(),Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, order.getOrderName());
				pst.setInt(2, order.getUserId());
				pst.setTimestamp(3, order.getPurchaseDate());
				return pst;
			}
		},keyHolder);
		
		int[] updateCounts = addOrderItems(keyHolder.getKey().intValue(), order.getItems());
		
		if(updateCounts.length != order.getItems().size()) {
			throw new ItemException("Order not completed!");
		} 
		return true;
	}
	
	private int[] addOrderItems(int orderId, List<PurchaseItem> items) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int[] updateCounts = mysqlJdbcTemplate
				.batchUpdate(mySqlQueriesProperty.getInsertOrderItems(), new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setInt(1, orderId);
						ps.setInt(2, items.get(i).getItemId());
						ps.setBigDecimal(3, items.get(i).getItemPurchasedPrice());
						ps.setInt(4, items.get(i).getQuantity());						
					}

					@Override
					public int getBatchSize() {
						return items.size();
					}});
		return updateCounts;
	}

	
	
}
