package com.nirmal.pachakari.dao;

public interface OrderDAO<Order> extends BaseDAO {
	public boolean addOrder(Order order);
}
