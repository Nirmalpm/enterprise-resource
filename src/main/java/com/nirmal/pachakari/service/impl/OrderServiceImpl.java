package com.nirmal.pachakari.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmal.pachakari.dao.OrderDAO;
import com.nirmal.pachakari.model.Order;
import com.nirmal.pachakari.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService<Order> {

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public boolean addOrder(Order order) {
		return orderDAO.addOrder(order);
	}

}
