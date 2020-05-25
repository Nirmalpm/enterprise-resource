package com.enterprise.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.resource.dao.OrderDAO;
import com.enterprise.resource.model.Order;
import com.enterprise.resource.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService<Order> {

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public boolean addOrder(Order order) {
		return orderDAO.addOrder(order);
	}

}
