package com.nirmal.pachakari.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmal.pachakari.email.EmailService;
import com.nirmal.pachakari.model.Order;
import com.nirmal.pachakari.service.OrderService;
import com.nirmal.pachakari.utils.CalendarUtil;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	
	OrderService orderService;
	EmailService emailService;
	
	public OrderController(OrderService orderService, EmailService emailService) {
		this.orderService = orderService;
		this.emailService = emailService;
	}

	@PostMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addOrder (@RequestBody Order order, HttpServletRequest request){
		String dateString = CalendarUtil.getDateString("yyyy-mm-dd-hh:mm a", order.getPurchaseDate());
		String userName = order.getUserId()+"->";
		String orderName = userName+dateString;
		order.setOrderName(orderName);
		this.orderService.addOrder(order);
		this.emailService.sendOrderMessage("nirmalpm@gmail.com", "Order Created", "Please find the order in your websote!",order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
