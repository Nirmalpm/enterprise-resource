package com.enterprise.resource.dao;

public interface OrderDAO<Order> extends BaseDAO {
	public boolean addOrder(Order order);
}
