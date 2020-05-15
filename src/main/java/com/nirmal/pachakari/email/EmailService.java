package com.nirmal.pachakari.email;

import com.nirmal.pachakari.model.Order;

public interface EmailService {
	public void sendMessage(String to, String subject, String text);
	public void sendMessageWithAttach(String to, String subject, String text, String filePath);
	public void sendOrderMessage(String to, String subject, String text,  Order order);
	public void sendOrderMessage(String to, String subject, String text, String filePath, Order order);
}
