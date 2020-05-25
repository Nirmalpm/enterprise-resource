package com.enterprise.resource.controllers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.resource.email.EmailService;
import com.enterprise.resource.model.Order;
import com.enterprise.resource.service.OrderService;
import com.enterprise.resource.utils.CalendarUtil;

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
		String dateString = CalendarUtil.getDateString("yyyymmdd", order.getPurchaseDate());
		String userName = order.getUserId()+"->";
		String orderName = userName+dateString;
		order.setOrderName(orderName);
		BigDecimal totalAmount = order.getItems().stream()
				.map((item)-> item.getItemPurchasedPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce((total, price)-> total.add(price)).get();
		int totalQuantity = order.getItems().stream()
				.map((item)-> item.getQuantity())
				.reduce((total, price)-> total+ price).get();
		order.setTotalPrice(totalAmount);
		order.setTotalQuantity(totalQuantity);
		this.orderService.addOrder(order);
		this.emailService.sendOrderMessage("nirmalpm@gmail.com", "Order Created", "Please find the order in your websote!",order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
