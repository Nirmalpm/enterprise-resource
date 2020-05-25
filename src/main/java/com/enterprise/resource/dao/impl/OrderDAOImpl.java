package com.enterprise.resource.dao.impl;

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

import com.enterprise.resource.config.MySqlQueriesProperty;
import com.enterprise.resource.dao.OrderDAO;
import com.enterprise.resource.errors.ItemException;
import com.enterprise.resource.model.Order;
import com.enterprise.resource.model.PurchaseItem;

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
				pst.setInt(1, order.getEnterpriseId());
				pst.setString(2, order.getOrderName());
				pst.setString(3, order.getUserId());
				pst.setTimestamp(4, order.getPurchaseDate());
				pst.setBigDecimal(5, order.getTotalPrice());
				pst.setInt(6, order.getTotalQuantity());
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
						ps.setInt(1, items.get(i).getEnterpriseId());
						ps.setInt(2, orderId);
						ps.setInt(3, items.get(i).getItemId());
						ps.setString(4, items.get(i).getItemName());
						ps.setBigDecimal(5, items.get(i).getItemPurchasedPrice());
						ps.setInt(6, items.get(i).getQuantity());						
					}

					@Override
					public int getBatchSize() {
						return items.size();
					}});
		return updateCounts;
	}

	
	
}
